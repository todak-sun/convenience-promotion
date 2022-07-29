import {config} from 'dotenv';

export class Configurator {
  private readonly config: Record<string, string | null>;
  constructor() {
    config();
    this.config = Object.entries(process.env).reduce((acc: Record<string, string | null>, [key, value]) => {
      acc[key] = value || null;
      return acc;
    }, {});
  }

  get = (key: string): string => {
    const ret = this.config[key];
    if (ret) {
      return ret;
    }
    throw new Error(`NOT FOUND KEY = ${key}`);
  };
}
