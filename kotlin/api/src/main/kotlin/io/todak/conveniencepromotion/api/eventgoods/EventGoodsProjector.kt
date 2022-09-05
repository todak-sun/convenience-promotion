package io.todak.conveniencepromotion.api.eventgoods

import com.querydsl.core.annotations.QueryProjection
import io.todak.conveniencepromotion.domain.eventgoods.StoreType


data class EventGoodsProjector @QueryProjection constructor(
    val eventGoodId: Long,
    val eventType: String,
    val store: StoreType,
    val productName: String,
    val price: Int,
    val imageSrc: String,
    val eventMonth: String
)
