package io.todak.conveniencepromotion.api.web


import io.todak.conveniencepromotion.api.helpers.WithContainers
import io.todak.conveniencepromotion.domain.eventgoods.EventGoodsEntity
import io.todak.conveniencepromotion.domain.eventgoods.StoreType
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.WebApplicationContext
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Transactional
@SpringBootTest
internal class EventGoodsControllerTest : WithContainers() {

    @Autowired
    lateinit var context: WebApplicationContext

    @PersistenceContext
    lateinit var em: EntityManager;


    lateinit var mvc: MockMvc

    @BeforeEach
    fun beforeEach() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context)
            .alwaysDo<DefaultMockMvcBuilder>(MockMvcResultHandlers.print())
            .build()

        val storeTypeSize = StoreType.values().size;
        for (i in 1..100) {
            em.persist(
                EventGoodsEntity(
                    "상품$i",
                    100 * i,
                    "image${i}.jpeg",
                    "1+1",
                    StoreType.values()[i % storeTypeSize]
                )
            )
        }
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
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isArray)
            .andExpect(jsonPath("$.length()", `is`(10)))
            .andExpect(jsonPath("$[0]").isMap)
            .andExpect(jsonPath("$[0].store").isString)
            .andExpect(jsonPath("$[0].price").isNumber)
            .andExpect(jsonPath("$[0].type").isString)
            .andExpect(jsonPath("$[0].productName").isString)
            .andExpect(jsonPath("$[0].imageSrc").isString)

    }


}