import {Configurator} from './configurator';

describe(`Configurator Test`, () => {
  it(`constructor`, () => {
    const configurator = new Configurator();
    configurator.get(`EXECUTABLE_PATH`)
  });
});
