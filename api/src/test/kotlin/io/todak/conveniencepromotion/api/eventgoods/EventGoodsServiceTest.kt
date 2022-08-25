package io.todak.conveniencepromotion.api.eventgoods

import io.todak.conveniencepromotion.api.helpers.WithContainers
import io.todak.conveniencepromotion.domain.eventgoods.StoreType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Pageable

@SpringBootTest
internal class EventGoodsServiceTest : WithContainers() {

    @Autowired
    lateinit var service: EventGoodsService;

    @DisplayName("findAll()")
    @Test
    fun findAllTest() {
        this.service.findAllEventGoods(Pageable.ofSize(10), EventGoodsQueryOptions(store = StoreType.CU))
    }
}

