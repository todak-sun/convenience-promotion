package io.todak.conveniencepromotion.api.web

import io.todak.conveniencepromotion.api.eventgoods.EventGoodsQueryOptions
import io.todak.conveniencepromotion.api.eventgoods.EventGoodsService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping(path = ["/eventgoods"])
@RestController
class EventGoodsController(private var eventGoodsService: EventGoodsService) {

    private val log: Logger = LoggerFactory.getLogger(javaClass)


    //  {{host}}/eventgoods?size={{size}}&page={{page}}&order={{id}}&store={{GS25|CU|EMART24|MINISTOP|SEVENELEVEN|ALL}}
    @GetMapping
    fun fetchAll(
        pageable: Pageable = PageRequest.of(0, 10),
        options: EventGoodsQueryOptions = EventGoodsQueryOptions()
    ) {
        log.info("pageable : {}", pageable)
        log.info("options : {}", options)
        this.eventGoodsService.findAllEventGoods(pageable, options)
    }


}


