package io.todak.conveniencepromotion.api.web

import io.todak.conveniencepromotion.api.helpers.WithContainers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
internal class EventGoodsControllerTest : WithContainers() {

    @Autowired
    lateinit var context: WebApplicationContext

    lateinit var mvc: MockMvc

    @BeforeEach
    fun beforeEach() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context)
            .alwaysDo<DefaultMockMvcBuilder>(MockMvcResultHandlers.print())
            .build()
    }

    @Test
    fun pageableTest() {
        this.mvc.perform(
            MockMvcRequestBuilders.get("/eventgoods")
                .queryParam("page", "1")
                .queryParam("size", "10")
                .queryParam("maxPrice", "5000")
                .queryParam("sort", "price,ASC")
        )

    }


}