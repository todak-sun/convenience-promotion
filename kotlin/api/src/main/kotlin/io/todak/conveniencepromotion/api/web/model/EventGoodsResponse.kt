package io.todak.conveniencepromotion.api.web.model

data class EventGoodsResponse(
    val store: String,
    val price: Int,
    val type: String,
    val productName: String,
    val imageSrc: String
)
