package io.todak.conveniencepromotion.api.eventgoods

import com.querydsl.jpa.impl.JPAQueryFactory
import io.todak.conveniencepromotion.domain.eventgoods.QEventGoodsEntity.eventGoodsEntity
import org.springframework.stereotype.Repository

@Repository
class EventGoodsQueryRepository(private val qf: JPAQueryFactory) {

    fun findEventGoods(): Unit {
        qf.select(eventGoodsEntity)
            .from(eventGoodsEntity)


    }

}