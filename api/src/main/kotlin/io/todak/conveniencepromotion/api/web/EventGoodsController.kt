package io.todak.conveniencepromotion.api.web

import io.todak.conveniencepromotion.api.eventgoods.EventGoodsQueryOptions
import io.todak.conveniencepromotion.api.eventgoods.EventGoodsService
import io.todak.conveniencepromotion.api.web.model.EventGoodsResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping(path = ["/eventgoods"])
@RestController
class EventGoodsController(private var eventGoodsService: EventGoodsService) {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun fetchAll(
        pageable: Pageable = PageRequest.of(1, 10),
        options: EventGoodsQueryOptions = EventGoodsQueryOptions()
    ): ResponseEntity<Any> {
        val eventGoods = this.eventGoodsService.findAllEventGoods(pageable, options)
        return ResponseEntity.ok(eventGoods.map { EventGoodsResponse(it.store.name, it.price, it.eventType, it.productName, it.imageSrc) }.toList())
    }


}


