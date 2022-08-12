package io.todak.conveniencepromotion.eventgoods

import io.todak.conveniencepromotion.web.model.EventGoodsResponse
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class EventGoodQueryService(
    private val repository: EventGoodsRepository,
    private val em: EntityManager
) {

    fun fetchAll(): List<EventGoodsResponse> =
        this.repository.findAll().map { EventGoodsResponse(it.store, it.price, it.productName) }

}

class QueryCondition(
    var page: Int = 0,
    var size: Int = 100,
    var store: String?,
) {
}