package io.todak.conveniencepromotion.processor.domain

import io.todak.conveniencepromotion.domain.eventgoods.StoreType


data class EventGoods(
    val eventType: String,
    val price: Int,
    val imageSrc: String,
    val productName: String,
    val store: StoreType
)
