export class Arguments {
  private constructor(private readonly params: Record<string, string>) {}

  public static parse(args: string[]) {
    const params = args.reduce((acc: Record<string, string>, curr: string) => {
      if (curr.includes(`--`)) {
        const [key, value] = curr.replace(`--`, '').split(`=`);
        acc[key] = value;
      }
      return acc;
    }, {});
    return new Arguments(params);
  }

  get = (key: string) => this.params[key];
}
