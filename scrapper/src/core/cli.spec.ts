import { Arguments } from './cli';
describe(`Arguments`, () => {
  it(`Arguments.parse`, () => {
    const args = Arguments.parse([`--name=Todak`]);
    expect(args.get(`name`)).toBe(`Todak`);
  });
});
