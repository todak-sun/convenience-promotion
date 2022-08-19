package io.todak.conveniencepromotion.api.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping(path = ["/eventgoods"])
@RestController
class EventGoodsController {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    //  {{host}}/eventgoods?size={{size}}&page={{page}}&order={{id}}&store={{GS25|CU|EMART24|MINISTOP|SEVENELEVEN|ALL}}
    @GetMapping
    fun fetchAll(pageable: Pageable) {
        log.info("pageable : {}", pageable)
    }


}



class EventGoodsQueryOptions {

}