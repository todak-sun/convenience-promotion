package io.todak.conveniencepromotion.processor.domain

import io.todak.conveniencepromotion.processor.helpers.WithContainers
import io.todak.conveniencepromotion.processor.logger
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import org.testcontainers.junit.jupiter.Testcontainers

import javax.persistence.EntityManager

@Transactional
@SpringBootTest
@Testcontainers
internal class EventGoodsEntityTest : WithContainers() {

    val log: Logger = logger()

    @Autowired
    lateinit var repository: EventGoodsRepository

    @Autowired
    lateinit var em: EntityManager;

    @DisplayName("생성 및 저장하는 테스트")
    @Test
    fun createAndSaveTest() {
        val eventGoods = EventGoodsEntity("productName", 1000, "https://image.com.jpg", "1+1", "CU")
        this.repository.save(eventGoods)
        assertNotNull(eventGoods.id)
        assertNotNull(eventGoods.createdDateTime)

        val eventGoodsId: Long = eventGoods.id!!
        em.flush()
        em.clear()

        val founded = this.repository.findById(eventGoodsId)
        assertTrue(founded.isPresent)
        val eventGoodsEntity = founded.get()
        log.info("eventMonth : ${eventGoodsEntity.eventMonth}")

    }


}