package io.todak.conveniencepromotion.processor.domain

import org.springframework.stereotype.Component

@Component
class Service {


    fun save(goods: EventGoods) {
        val entity =
            EventGoodsEntity(null, goods.productName, goods.price, goods.imageSrc, goods.eventType, goods.store)
    }

}