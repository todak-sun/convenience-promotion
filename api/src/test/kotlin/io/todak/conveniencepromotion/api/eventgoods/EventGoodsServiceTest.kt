package io.todak.conveniencepromotion.api.eventgoods

import io.todak.conveniencepromotion.api.helpers.WithContainers
import io.todak.conveniencepromotion.domain.eventgoods.StoreType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

@SpringBootTest
internal class EventGoodsServiceTest : WithContainers() {

    @Autowired
    lateinit var service: EventGoodsService

    @DisplayName("findAll()")
    @Test
    fun findAllTest() {
        this.service.findAllEventGoods(PageRequest.of(2, 100), EventGoodsQueryOptions(store = StoreType.CU))

        this.service.findAllEventGoods(
            PageRequest.of(1, 10), EventGoodsQueryOptions(
                store = null,
                minPrice = 1000,
                maxPrice = 5000
            )
        )

        this.service.findAllEventGoods(
            PageRequest.of(10, 100, Sort.by("price").ascending()),
            EventGoodsQueryOptions(
                store = StoreType.EMART24,
                minPrice = 5000,
                maxPrice = 10000
            )
        )


    }
}

