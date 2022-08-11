package io.todak.conveniencepromotion.eventgoods

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EventGoodsRepository : JpaRepository<EventGoodsEntity, Long> {
    fun findByProductNameAndEventMonthAndStore(
        productName: String,
        eventMonth: String,
        store: String
    ): Optional<EventGoodsEntity>

}