package io.todak.conveniencepromotion.api.eventgoods

import io.todak.conveniencepromotion.domain.eventgoods.StoreType
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Transactional(readOnly = true)
@Service
class EventGoodsService(private val repository: EventGoodsQueryRepository) {
    fun findAllEventGoods(pageable: Pageable, options: EventGoodsQueryOptions): MutableList<EventGoodsProjector> {
        val pageResult = this.repository.findEventGoods(
            PageRequest.of(pageable.pageNumber - 1, pageable.pageSize, pageable.sort),
            EventGoodsWhereCondition(options.store, options.minPrice, options.maxPrice)
        )
        return pageResult.content
    }
}

data class EventGoodsQueryOptions(val store: StoreType? = null, val minPrice: Int? = null, val maxPrice: Int? = null)