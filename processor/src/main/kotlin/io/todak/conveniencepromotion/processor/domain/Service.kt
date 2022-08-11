package io.todak.conveniencepromotion.processor.domain

import io.todak.conveniencepromotion.eventgoods.EventGoodsEntity
import io.todak.conveniencepromotion.eventgoods.EventGoodsRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Transactional
@Service
class Service(private val repository: EventGoodsRepository) {
    fun save(goods: EventGoods) {
        val now = LocalDateTime.now()
        val eventMonth = "${now.year}-${now.monthValue.toString().padStart(2, '0')}"
        val founded = this.repository.findByProductNameAndEventMonthAndStore(goods.productName, eventMonth, goods.store)
        if (founded.isPresent) {
            return
        }
        val entity:EventGoodsEntity = EventGoodsEntity(goods.productName, goods.price, goods.imageSrc, goods.eventType, goods.store)
        this.repository.save(entity)
    }
}