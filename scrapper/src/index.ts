import { Arguments } from './core/cli';
import { isStoreType, StoreType, EventGoods } from './model/model';
import { EventGoodsRobot } from './robots/index';
import { CUEventGoodsRobot } from './robots/cu';
import { Configurator } from './core/configurator';
import { Emart24GoodsRobot } from './robots/emart24';
import { GS25EventGoodsRobot } from './robots/gs25';
import { MinistopGoodsRobot } from './robots/ministop';
import { SevenElevenGoodsRobot } from './robots/seveneleven';
import { RabbitMQPublisher } from './message/message';

async function run(arvs: string[] = process.argv.slice(2)) {
  const robotFactory: Record<StoreType, (configurator: Configurator) => EventGoodsRobot> = {
    CU: (configurator: Configurator) => new CUEventGoodsRobot(configurator),
    EMART24: (configurator: Configurator) => new Emart24GoodsRobot(configurator),
    GS25: (configurator: Configurator) => new GS25EventGoodsRobot(configurator),
    MINISTOP: (configurator: Configurator) => new MinistopGoodsRobot(configurator),
    SEVENELEVEN: (configurator: Configurator) => new SevenElevenGoodsRobot(configurator),
  };

  const args = Arguments.parse(arvs);
  const storeType = args.get(`store`);

  if (isStoreType(storeType)) {
    console.log(`PROCESS START => STORE = ${storeType}`)
    const configurator = new Configurator();
    const publisher = new RabbitMQPublisher<EventGoods>(configurator);
    await publisher.connect({ topicName: `CONVINIENCE.EVENT.GOODS`, routingKey: `ITEM`, queueNames: [`PROCESSOR`] });
    const robot: EventGoodsRobot = robotFactory[storeType](configurator);
    const eventGoods = await robot.scrap();

    await publisher.publishAll(eventGoods);
    await publisher.close();
    console.log(`PROCESS END`)
  } else {
    throw new Error(`Require arguments --store={one of [${Object.keys(StoreType).join(', ')}]}`);
  }
}

run();
