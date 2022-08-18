package io.todak.conveniencepromotion.api.eventgoods

import io.todak.conveniencepromotion.api.helpers.WithContainers
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class EventGoodsServiceTest : WithContainers() {

    @Autowired
    lateinit var service: EventGoodsService;

    @DisplayName("findAll()")
    @Test
    fun findAllTest() {
        this.service.findAll()
    }
}

