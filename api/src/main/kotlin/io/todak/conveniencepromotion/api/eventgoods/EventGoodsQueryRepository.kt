package io.todak.conveniencepromotion.api.eventgoods

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.dsl.Expressions
import com.querydsl.jpa.impl.JPAQueryFactory
import io.todak.conveniencepromotion.domain.eventgoods.EventGoodsEntity
import io.todak.conveniencepromotion.domain.eventgoods.QEventGoodsEntity.eventGoodsEntity
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


class EventGoodsWhereCondition(
    val store: String?,
    val sort: String = "productName",
    val orderBy: OrderBy
)


@Transactional(readOnly = true)
@Repository
class EventGoodsQueryRepository(private val qf: JPAQueryFactory) {

    private val log = LoggerFactory.getLogger(javaClass);
    fun findEventGoods(condition: EventGoodsWhereCondition): MutableList<EventGoodsEntity> {
        val pageable: Pageable = PageRequest.of(1, 10)

        return qf.select(eventGoodsEntity)
            .from(eventGoodsEntity)
            .where(BooleanBuilder().apply {
                condition.store.let { this.and(eventGoodsEntity.store.eq(it)) }
            })
            .limit(pageable.pageSize.toLong())
            .orderBy(OrderSpecifier(Order.ASC, Expressions.path(String::class.java, eventGoodsEntity, "productName")))
            .offset(pageable.offset)
            .fetch()
    }

}