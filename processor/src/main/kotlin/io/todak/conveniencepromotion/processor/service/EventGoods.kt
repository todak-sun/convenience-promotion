package io.todak.conveniencepromotion.processor.service

data class EventGoods(
    val eventType: String,
    val price: Int,
    val imageSrc: String,
    val productName: String,
    val store: String
)
