package io.todak.conveniencepromotion.processor.domain;

import io.todak.conveniencepromotion.domain.eventgoods.EventGoodsEntity;
import io.todak.conveniencepromotion.domain.eventgoods.StoreType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventGoodsRepository extends JpaRepository<EventGoodsEntity, Long> {

    Optional<EventGoodsEntity> findByProductNameAndEventMonthAndStore(String productName, String eventMonth, StoreType store);

}
