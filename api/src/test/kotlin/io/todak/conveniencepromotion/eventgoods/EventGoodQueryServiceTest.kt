package io.todak.conveniencepromotion.eventgoods

import io.todak.conveniencepromotion.helpers.WithContainers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EventGoodQueryServiceTest : WithContainers() {

    @Autowired
    lateinit var service: EventGoodQueryService

    @Test
    fun fetchAllTest() {
        val fetched = this.service.fetchAll()
    }

}