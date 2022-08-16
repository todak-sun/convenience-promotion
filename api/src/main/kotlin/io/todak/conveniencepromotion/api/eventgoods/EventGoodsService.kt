package io.todak.conveniencepromotion.api.eventgoods

import io.todak.conveniencepromotion.domain.eventgoods.EventGoodsEntity
import io.todak.conveniencepromotion.domain.eventgoods.EventGoodsRepository
import org.springframework.stereotype.Service

@Service
class EventGoodsService(private val repository: EventGoodsRepository) {

    fun findAll(): MutableList<EventGoodsEntity> {
        return this.repository.findAll()
    }

}