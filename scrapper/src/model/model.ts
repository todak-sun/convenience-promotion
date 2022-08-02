export const StoreType = {
  EMART24: `EMART24`,
  CU: `CU`,
  MINISTOP: `MINISTOP`,
  GS25: `GS25`,
  SEVENELEVEN: `SEVENELEVEN`,
} as const;

export type StoreType = keyof typeof StoreType;

export const isStoreType = (value: any): value is StoreType => Boolean(StoreType[value as StoreType]);

export interface EventGoods {
  store: StoreType;
  imageSrc: string;
  productName: string;
  price: number;
  eventType: string;
}
