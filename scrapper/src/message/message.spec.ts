import { Configurator } from '../core/configurator';
import { RabbitMQPublisher } from './message';
describe(`RabbitMQPublisher`, () => {
  it(`publish()`, async () => {
    const publisher = new RabbitMQPublisher(new Configurator());
    await publisher.connect({ topicName: `CONVINIENCE.EVENT.GOODS`, routingKey: `ITEM`, queueNames: [`PROCESSOR`] });

    for (let i = 0; i < 10; i++) {
      await publisher.publish({ hello: `world${i}` });
    }

    await publisher.close();
  });
});
