import type { EventGoodType} from '../api/eventgoods';

export interface EventGoodProps {
  eventgood: EventGoodType;
}

export const EventGood = (props: EventGoodProps) => {
  const good = props.eventgood;
  return (
    <li key={good.productName}>
      <div>
        <div>
          <img src={good.imageSrc} alt={good.productName} />
        </div>
        <h4>{good.productName}</h4>
        <p>
          <span>가격</span>
          <span>{good.price}원</span>
        </p>
        <p>{good.eventMonth}</p>
      </div>
    </li>
  );
};
