package io.todak.conveniencepromotion.api.eventgoods

import com.querydsl.core.annotations.QueryProjection
import io.todak.conveniencepromotion.domain.eventgoods.StoreType


data class EventGoodsProjector @QueryProjection constructor(
    private val eventGoodId: Long,
    private val eventType: String,
    private val store: StoreType,
    private val productName: String,
    private val price: Int,
    private val imageSrc: String,
    private val eventMonth: String
)
