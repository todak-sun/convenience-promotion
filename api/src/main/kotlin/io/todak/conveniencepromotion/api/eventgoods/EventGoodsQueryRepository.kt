package io.todak.conveniencepromotion.api.eventgoods

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.dsl.Expressions
import com.querydsl.jpa.impl.JPAQueryFactory
import io.todak.conveniencepromotion.domain.eventgoods.QEventGoodsEntity.eventGoodsEntity
import io.todak.conveniencepromotion.domain.eventgoods.StoreType
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Transactional(readOnly = true)
@Repository
class EventGoodsQueryRepository(private val qf: JPAQueryFactory) {

    private val log = LoggerFactory.getLogger(javaClass)
    fun findEventGoods(pageable: Pageable, condition: EventGoodsWhereCondition): Page<EventGoodsProjector> {

        val orderSpecifiers = pageable.sort.map {
            OrderSpecifier(
                if (it.direction.isAscending) Order.ASC else Order.DESC,
                Expressions.path(String::class.java, eventGoodsEntity, it.property)
            )
        }.toList()

        val whereCondition = BooleanBuilder().apply {
            condition.store?.let { this.and(eventGoodsEntity.store.eq(it)) }
            condition.minPrice?.let { this.and(eventGoodsEntity.price.goe(it)) }
            condition.maxPrice?.let { this.and(eventGoodsEntity.price.loe(it)) }
        };

        val count = qf.select(eventGoodsEntity.count())
            .from(eventGoodsEntity)
            .where(whereCondition)
            .fetchOne()

        val items = qf.select(
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
            .where(whereCondition)
            .limit(pageable.pageSize.toLong())
            .orderBy(*orderSpecifiers.toTypedArray())
            .offset(pageable.offset)
            .fetch()
        return PageImpl(items, pageable, count!!)
    }
}

data class EventGoodsWhereCondition(val store: StoreType?, val minPrice: Int?, val maxPrice: Int?)