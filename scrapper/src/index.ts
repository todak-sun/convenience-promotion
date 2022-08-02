import { Arguments } from './core/cli';
import { isStoreType, StoreType } from './model/model';
import { EventGoodsRobot } from './robots/index';
import { CUEventGoodsRobot } from './robots/cu';
import { Configurator } from './core/configurator';
import { Emart24GoodsRobot } from './robots/emart24';
import { GS25EventGoodsRobot } from './robots/gs25';
import { MinistopGoodsRobot } from './robots/ministop';
import { SevenElevenGoodsRobot } from './robots/seveneleven';

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
    const configurator = new Configurator();
    const robot: EventGoodsRobot = robotFactory[storeType](configurator);
    const eventGoods = await robot.scrap();
    console.log(JSON.stringify({ eventGoods }));
  } else {
    throw new Error(`Require arguments --store={one of [${Object.keys(StoreType).join(', ')}]}`);
  }
}

run();
