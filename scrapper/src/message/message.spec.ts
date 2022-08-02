import { Channel } from 'amqplib';
import { Configurator } from '../core/configurator';
import { RabbitMQPublisher } from './message';
describe(`RabbitMQPublisher`, () => {
  it(`getConnection()`, async () => {
    const publisher = new RabbitMQPublisher(new Configurator());
    const connection = await publisher.getConnection();

    const channel: Channel = await connection.createChannel();
    const routingKey = `ITEM`;
    const topicName = `CONVINIENCE.EVENT.GOODS`;
    await channel.assertExchange(topicName, `topic`, { durable: false });

    await Promise.all(
      [`PROCESSOR`]
        .map((queueName) => [topicName, queueName].join('.'))
        .map(async (queueName) => {
          await channel.assertQueue(queueName, { durable: true });
          await channel.bindQueue(queueName, topicName, routingKey);
        })
    );

    channel.publish(topicName, routingKey, Buffer.from(JSON.stringify({ hello: `world` })), {
      contentType: `application/json`,
      contentEncoding: `utf-8`,
    });
    await channel.close()
    await connection.close();
  });
});
