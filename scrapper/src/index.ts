import { Arguments } from './core/cli';
import { Configurator } from './core/configurator';
import { RabbitMQPublisher } from './message/message';
import { EventGoods, isStoreType, StoreType } from './model/model';
import { CUEventGoodsRobot } from './robots/cu';
import { Emart24GoodsRobot } from './robots/emart24';
import { GS25EventGoodsRobot } from './robots/gs25';
import { EventGoodsRobot } from './robots/index';
import { MinistopGoodsRobot } from './robots/ministop';
import { SevenElevenGoodsRobot } from './robots/seveneleven';

interface RobotFactory {
  (configurator: Configurator): EventGoodsRobot;
}

async function run(arvs: string[] = process.argv.slice(2)) {
  const robotFactory: Record<StoreType, RobotFactory> = {
    CU: (configurator: Configurator) => new CUEventGoodsRobot(configurator),
    EMART24: (configurator: Configurator) => new Emart24GoodsRobot(configurator),
    GS25: (configurator: Configurator) => new GS25EventGoodsRobot(configurator),
    MINISTOP: (configurator: Configurator) => new MinistopGoodsRobot(configurator),
    SEVENELEVEN: (configurator: Configurator) => new SevenElevenGoodsRobot(configurator),
  };

  const args = Arguments.parse(arvs);
  const storeType = args.get(`store`);

  const isValidStoreType = (storeType: string) => isStoreType(storeType) || storeType === `ALL`;
  if (!isValidStoreType(storeType)) {
    throw new Error(`Require arguments --store={one of [${Object.keys(StoreType).join(', ')}] or ALL }`);
  } else {
    console.log(`==============================> PROCESS START`);
    const configurator = new Configurator();
    const publisher = new RabbitMQPublisher<EventGoods>(configurator);
    await publisher.connect({ topicName: `CONVINIENCE.EVENT.GOODS`, routingKey: `ITEM`, queueNames: [`PROCESSOR`] });

    const taskList: [StoreType, EventGoodsRobot][] = [];

    if (isStoreType(storeType)) {
      const robot: EventGoodsRobot = robotFactory[storeType](configurator);
      taskList.push([storeType, robot]);
    } else if (storeType === `ALL`) {
      Object.entries(robotFactory).forEach(([storeType, createRobot]: [string, RobotFactory]) => {
        if (isStoreType(storeType)) {
          taskList.push([storeType, createRobot(configurator)]);
        }
      });
    }

    const collectedItems: EventGoods[] = await taskList.reduce(
      async (promisableAcc: Promise<EventGoods[]>, [store, robot]: [StoreType, EventGoodsRobot], index: number) => {
        let acc = await promisableAcc;
        console.log(`-----------------------------------------------`)
        console.log(`[${store}] COLLECTOR START!!! - [ ${index + 1} / ${taskList.length} ]`);
        const eventGoods = await robot.scrap();
        acc = acc.concat(eventGoods);
        console.log(`[${store}] COLLECTOR END. Collected a total of ${eventGoods.length} ${store} items.`);
        console.log(`-----------------------------------------------`)
        return acc;
      },
      Promise.resolve([])
    );

    console.log(`Collected a total of ${collectedItems.length} All items.`);
    await publisher.publishAll(collectedItems);
    await publisher.close();
    console.log(`==============================> PROCESS END`);
  }
}

run();
