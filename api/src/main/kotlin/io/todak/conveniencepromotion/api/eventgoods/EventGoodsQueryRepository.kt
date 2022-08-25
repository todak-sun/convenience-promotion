package io.todak.conveniencepromotion.api.eventgoods

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.dsl.Expressions
import com.querydsl.jpa.impl.JPAQueryFactory
import io.todak.conveniencepromotion.domain.eventgoods.QEventGoodsEntity.eventGoodsEntity
import io.todak.conveniencepromotion.domain.eventgoods.StoreType
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Transactional(readOnly = true)
@Repository
class EventGoodsQueryRepository(private val qf: JPAQueryFactory) {

    private val log = LoggerFactory.getLogger(javaClass)
    fun findEventGoods(pageable: Pageable, condition: EventGoodsWhereCondition): MutableList<EventGoodsProjector> {

        val orderSpecifiers = pageable.sort.map {
            OrderSpecifier(
                if (it.direction.isAscending) Order.ASC else Order.DESC,
                Expressions.path(String::class.java, eventGoodsEntity, it.property)
            )
        }.toList()


        return qf.select(
            QEventGoodsProjector(
                eventGoodsEntity.id,
                eventGoodsEntity.eventType,
                eventGoodsEntity.store,
                eventGoodsEntity.productName,
                eventGoodsEntity.price,
                eventGoodsEntity.imageSrc,
                eventGoodsEntity.eventMonth
            )
        )
            .from(eventGoodsEntity)
            .where(BooleanBuilder().apply {
                condition.store.let { this.and(eventGoodsEntity.store.eq(StoreType.CU)) }
            })
            .limit(pageable.pageSize.toLong())
            .orderBy(*orderSpecifiers.toTypedArray())
            .offset(pageable.offset)
            .fetch()
    }
}

data class EventGoodsWhereCondition(val store: StoreType?)