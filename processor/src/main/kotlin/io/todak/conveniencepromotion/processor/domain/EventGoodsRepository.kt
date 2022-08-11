package io.todak.conveniencepromotion.processor.domain

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EventGoodsRepository : JpaRepository<EventGoodsEntity, Long> {

    fun findByProductNameAndEventMonth(productName: String, eventMonth: String): Optional<EventGoodsEntity>

}