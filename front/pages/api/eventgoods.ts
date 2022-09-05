import type {NextApiRequest, NextApiResponse} from 'next';

export type EventGoodType = {
  store: string;
  eventMonth: string;
  imageSrc: string;
  eventType: string;
  productName: string;
  price: number;
};

export default function eventgoods(req: NextApiRequest, res: NextApiResponse<EventGood[]>) {
  console.log(`CALL`);
  res.status(200).json([
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809064634570.jpg', eventType: '1+1', productName: '송원)아삭한복숭아2입', price: 8800, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809064634563.jpg', eventType: '1+1', productName: '송원)부드러운복숭아2입', price: 8800, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809293682472.jpg', eventType: '1+1', productName: '맛있다)곤약젤리복숭아130g', price: 2000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809293682489.jpg', eventType: '1+1', productName: '맛있다)곤약젤리포도130g', price: 2000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809293684070.jpg', eventType: '1+1', productName: '맛있다)곤약젤리자몽130g', price: 2000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809293682465.jpg', eventType: '1+1', productName: '맛있다)곤약젤리사과130g', price: 2000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801123203918.jpg', eventType: '1+1', productName: '롯데)키스틱55g', price: 2000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801066061095.jpg', eventType: '1+1', productName: '사조)닭가슴살꼬꼬봉50g', price: 1800, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801047579229.jpg', eventType: '1+1', productName: '동원)포킷포킷소시지70g  ', price: 2500, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801047578857.jpg', eventType: '1+1', productName: '동원)친친오리지널소시지70g', price: 1900, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801047578970.jpg', eventType: '1+1', productName: '동원)친친콘치즈소시지70g', price: 1900, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801007918310.jpg', eventType: '1+1', productName: 'CJ)백설구이한판스모크60g', price: 3300, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801007403793.jpg', eventType: '1+1', productName: 'CJ)맥스봉빅소시지150g', price: 3500, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801007957180.jpg', eventType: '1+1', productName: 'CJ)닭가슴살직화화다닭75g', price: 3700, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801007849126.jpg', eventType: '1+1', productName: 'CJ)맥스봉오리지널50g', price: 2000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8805489000594.jpg', eventType: '1+1', productName: '쉐프)소고기쌀국수143g', price: 3900, store: 'EMART24'},
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8805489001072.jpg',
      eventType: '1+1',
      productName: '쉐프)얼큰버섯샤브쌀국수150g',
      price: 3900,
      store: 'EMART24',
    },
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801115225591.jpg', eventType: '1+1', productName: '서울)듀오안사과150ml', price: 1700, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801115225614.jpg', eventType: '1+1', productName: '서울)듀오안플레인150ml', price: 1700, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801121036426.jpg', eventType: '1+1', productName: '매일)바이오오!그래놀라127g', price: 2000, store: 'EMART24'},
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801121032596.jpg',
      eventType: '1+1',
      productName: '매일)바이오초코링&프로틴볼127g',
      price: 2000,
      store: 'EMART24',
    },
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104302739.jpg', eventType: '1+1', productName: '빙그레)닥터캡슐플레인130ml', price: 1900, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104665421.jpg', eventType: '1+1', productName: '빙그레)닥터캡슐사과130ml', price: 1900, store: 'EMART24'},
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104669283.jpg',
      eventType: '1+1',
      productName: '빙그레)닥터캡슐베리믹스130ml',
      price: 1900,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104667043.jpg',
      eventType: '1+1',
      productName: '빙그레)스페셜티예가체프460ml',
      price: 2500,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104667029.jpg',
      eventType: '1+1',
      productName: '빙그레)스페셜티탄자니아460ml',
      price: 2500,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104666626.jpg',
      eventType: '1+1',
      productName: '빙그레)요플레프로틴플레인210ml',
      price: 2900,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104666640.jpg',
      eventType: '1+1',
      productName: '빙그레)요플레프로틴딸기바나나210ml',
      price: 2900,
      store: 'EMART24',
    },
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104220125.jpg', eventType: '1+1', productName: '빙그레)초코타임200ml', price: 950, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104220200.jpg', eventType: '1+1', productName: '빙그레)딸기타임200ml', price: 950, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104671002.jpg', eventType: '1+1', productName: '빙그레)복숭아아이스티300ml', price: 1200, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104671019.jpg', eventType: '1+1', productName: '빙그레)레몬아이스티300ml', price: 1200, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801123103454.jpg', eventType: '1+1', productName: '푸르밀)가나쵸코우유300ml', price: 1650, store: 'EMART24'},
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8806371301614.jpg',
      eventType: '1+1',
      productName: '푸르밀)검은콩이들어있는우유300ml',
      price: 1650,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8806371309771.jpg',
      eventType: '1+1',
      productName: '푸르밀)웰치스포도에이드250ml',
      price: 1500,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8806371309818.jpg',
      eventType: '1+1',
      productName: '푸르밀)웰치스사과에이드250ml',
      price: 1500,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8806371340040.jpg',
      eventType: '1+1',
      productName: '푸르밀)웰치스오렌지블랙티250ml',
      price: 1500,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809350884474.jpg',
      eventType: '1+1',
      productName: '서울F&B)카베르네소비뇽적포도주스190ml',
      price: 2500,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809350884467.jpg',
      eventType: '1+1',
      productName: '서울F&B)머스캣백포도주스190ml',
      price: 2500,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809274514945.jpg',
      eventType: '1+1',
      productName: '풀무원)액티비아스무디딸기바나나150ml',
      price: 2000,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809274514969.jpg',
      eventType: '1+1',
      productName: '풀무원)액티비아스무디골드키위사과150ml',
      price: 2000,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801207050117.jpg',
      eventType: '1+1',
      productName: '롯데푸드)쾌변사과요구르트150ml',
      price: 1700,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801207060918.jpg',
      eventType: '1+1',
      productName: '롯데푸드)쾌변포도요구르트150ml',
      price: 1700,
      store: 'EMART24',
    },
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801094202606.jpg', eventType: '1+1', productName: '스프라이트500ml', price: 2000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801094962104.jpg', eventType: '1+1', productName: '코카)스프라이트제로500ml', price: 2000, store: 'EMART24'},
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801094552107.jpg',
      eventType: '1+1',
      productName: '조지아)라떼니스타크리미라떼280ml',
      price: 2300,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801094562120.jpg',
      eventType: '1+1',
      productName: '조지아)라떼니스타카라멜라떼280ml',
      price: 2300,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801094562601.jpg',
      eventType: '1+1',
      productName: '조지아)크래프트콜드블랙370ml',
      price: 2500,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801094582302.jpg',
      eventType: '1+1',
      productName: '조지아)크래프트콜드라떼370ml',
      price: 2500,
      store: 'EMART24',
    },
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801094052607.jpg', eventType: '1+1', productName: '코카)닥터페퍼500ml', price: 2100, store: 'EMART24'},
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801094342623.jpg',
      eventType: '1+1',
      productName: '태양의원차)주전자차보리500ml',
      price: 2000,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801094342630.jpg',
      eventType: '1+1',
      productName: '태양의원차)주전자차옥수수500ml',
      price: 2000,
      store: 'EMART24',
    },
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801105916553.jpg', eventType: '1+1', productName: '해태)숙취엔IdH175ml', price: 5000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8806002018201.jpg', eventType: '1+1', productName: '광동)경옥진100ml', price: 5000, store: 'EMART24'},
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8806002020334.jpg',
      eventType: '1+1',
      productName: '광동)더진한헛개차골드라벨500ml',
      price: 3000,
      store: 'EMART24',
    },
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8806002021416.jpg', eventType: '1+1', productName: '광동)온더그린400ml', price: 3000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8806002021577.jpg', eventType: '1+1', productName: '광동)온더게임400ml', price: 3000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801382149675.jpg', eventType: '1+1', productName: '웅진)초록매실1L', price: 3300, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801382149644.jpg', eventType: '1+1', productName: '웅진)아침햇살1L', price: 3300, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809422041125.jpg', eventType: '1+1', productName: 'HK)새싹보리500ml', price: 2000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809422041729.jpg', eventType: '1+1', productName: 'HK)헛개수EX500ml', price: 3000, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801223007478.jpg', eventType: '1+1', productName: '일화)천연사이다캔350ml', price: 1200, store: 'EMART24'},
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809713913896.jpg',
      eventType: '1+1',
      productName: '코오롱)정신차리솟!에너지드링크350ml',
      price: 2000,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809514644029.jpg',
      eventType: '1+1',
      productName: '비비랩)티블링캐모마일피치500ml',
      price: 2500,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8809514644036.jpg',
      eventType: '1+1',
      productName: '비비랩)티블링레몬그라스진저500ml',
      price: 2500,
      store: 'EMART24',
    },
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801047289685.jpg', eventType: '1+1', productName: '동원)오미자차500ml', price: 2200, store: 'EMART24'},
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801047291282.jpg', eventType: '1+1', productName: '동원)양반매실차500ml', price: 2200, store: 'EMART24'},
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8803186000213.jpg',
      eventType: '1+1',
      productName: '청정)몽베스트스파클링워터레몬500ml',
      price: 1700,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8803186000220.jpg',
      eventType: '1+1',
      productName: '청정)몽베스트스파클링워터라임500ml',
      price: 1700,
      store: 'EMART24',
    },
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8808024030803.jpg', eventType: '1+1', productName: '쟈뎅)청보리차500ml', price: 2000, store: 'EMART24'},
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104669672.jpg',
      eventType: '1+1',
      productName: '빙그레)아카페라AllDay헤이즐넛1L',
      price: 4200,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8801104669658.jpg',
      eventType: '1+1',
      productName: '빙그레)아카페라AllDay아메리카노1L',
      price: 4200,
      store: 'EMART24',
    },
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8806011618249.jpg', eventType: '1+1', productName: '박카스)디카페120ml', price: 800, store: 'EMART24'},
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8805915553212.jpg',
      eventType: '1+1',
      productName: '종근당건강)락토조이제로워터350ml',
      price: 2000,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8805915553915.jpg',
      eventType: '1+1',
      productName: '종근당건강)올앳미V스파클링350ml',
      price: 2000,
      store: 'EMART24',
    },
    {
      eventMonth: '2022-08',
      imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8805915554110.jpg',
      eventType: '1+1',
      productName: '종근당건강)락토조이S스파클링350ml',
      price: 2000,
      store: 'EMART24',
    },
    {eventMonth: '2022-08', imageSrc: 'https://emart24.co.kr/upload/eventProduct/202208/8806011416012.jpg', eventType: '1+1', productName: '동아)모닝케어S100ml', price: 5000, store: 'EMART24'},
  ]);
}