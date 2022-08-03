import { Channel, connect, Connection } from 'amqplib';
import { Configurator } from '../core/configurator';

export type RabbitMQPublisherConnectOptions = {
  topicName: string;
  routingKey: string;
  queueNames?: string[];
};

export class RabbitMQPublisher {
  private connection: Connection | undefined;

  private topicName: string | undefined;
  private queueNames: string[] | undefined;
  private routingKey: string | undefined;

  constructor(private readonly configurator: Configurator) {}

  connect = async (options: RabbitMQPublisherConnectOptions) => {
    if (this.connection) {
      throw new Error(`이미 연결중입니다.`);
    }
    const { topicName, queueNames, routingKey } = options;
    this.connection = await connect({
      hostname: this.configurator.get(`RABBITMQ_HOSTNAME`),
      protocol: this.configurator.get(`RABBITMQ_PROTOCOL`),
      port: this.configurator.getNumber(`RABBITMQ_PORT`),
    });

    process.once(`SIGINT`, async () => this.connection?.close());

    const channel: Channel = await this.connection.createChannel();
    await channel.assertExchange(topicName, `topic`, { durable: true });
    if (queueNames) {
      await Promise.all(
        queueNames
          .map((queueName) => [topicName, queueName].join('.'))
          .map(async (queueName) => {
            await channel.assertQueue(queueName, { durable: true });
            await channel.bindQueue(queueName, topicName, routingKey);
          })
      );
    }
    await channel.close();

    this.topicName = topicName;
    this.routingKey = routingKey;
    if (queueNames) {
      this.queueNames = queueNames;
    }
  };

  publish = async (message: any) => {
    if (!this.connection) {
      throw new Error(`현재 연결되어 있지 않습니다.`);
    }
    const ch: Channel = await this.connection.createChannel();
    this.publishInternal(ch, message);
    await ch.close();
  };

  publishAll = async (messages: any[]) => {
    if (!this.connection) {
      throw new Error(`현재 연결되어 있지 않습니다.`);
    }
    const ch: Channel = await this.connection.createChannel();
    messages.forEach((message) => this.publishInternal(ch, message));
    await ch.close();
  };

  private publishInternal = (ch: Channel, message: any): boolean => {
    return ch.publish(this.topicName!, this.routingKey!, Buffer.from(JSON.stringify(message)), {
      contentEncoding: `utf-8`,
      contentType: `application/json`,
    });
  };

  close = async (): Promise<void> => await this.connection?.close();
}
