package io.todak.conveniencepromotion.api.eventgoods

import io.todak.conveniencepromotion.api.web.EventGoodsQueryOptions
import io.todak.conveniencepromotion.domain.eventgoods.EventGoodsEntity
import org.springframework.stereotype.Service
import java.awt.print.Pageable

@Service
class EventGoodsService(private val repository: EventGoodsQueryRepository) {

    fun findAll(pageable: Pageable, options: EventGoodsQueryOptions): MutableList<EventGoodsEntity> {

        return this.repository.findEventGoods(EventGoodsWhereCondition("GS25", "price", OrderBy.ASC))
    }

}