import { config } from 'dotenv';
import * as path from 'path';
export class Configurator {
  private readonly config: Record<string, string | null>;
  constructor() {
    const envPath = process.env.NODE_ENV ? path.resolve(process.cwd(), `.${process.env.NODE_ENV}.env`) : path.resolve(process.cwd(), '.env');
    config({ path: envPath });
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

  getBoolean = (key: string): boolean => {
    return this.get(key) === `true`;
  };

  getNumber = (key: string): number => {
    return Number(this.get(key));
  };
}
