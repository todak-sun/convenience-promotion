import { connect, Connection } from 'amqplib';
import { Configurator } from '../core/configurator';

export class RabbitMQPublisher {
  private connection: Connection | undefined;
  constructor(private readonly configurator: Configurator) {}

  getConnection = async () => {
    if (!this.connection) {
      this.connection = await connect({
        hostname: this.configurator.get(`RABBITMQ_HOSTNAME`),
        protocol: this.configurator.get(`RABBITMQ_PROTOCOL`),
        port: this.configurator.getNumber(`RABBITMQ_PORT`),
      });
    }
    return this.connection;
  };

  close = async () => await this.connection?.close();
}
