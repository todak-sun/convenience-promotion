export interface EventGoodsResponse {
  abrGoodsNm: string;
  attFileId: string;
  attFileNm: string;
  attFileNmOld: string;
  eventTypeNm: string;
  eventTypeSp: {code: string; codeLowerCase: string};
  goodsNm: string;
  goodsStat: {code: string; codeLowerCase: string};
  goodsStatAppDt: string;
  goodsStatNm: string;
  goodsStatNmOld: string;
  goodsStatOld: {code: string; codeLowerCase: string};
  imageFileAppDt: string;
  price: number;
  priceApplyDate: string;
  priceOld: number;
  prmtBuyQty: 0;
  prmtCd: string;
  prmtPriority: number;
  prmtYear: string;
}

export interface EventGoodsPagination {
  currentPage: number;
  numberOfPages: number;
  pageSize: number;
  totalNumberOfResults: number;
}

export interface EventGoodsResponseWrapper {
  results: EventGoodsResponse[];
  pagination: EventGoodsPagination;
}
