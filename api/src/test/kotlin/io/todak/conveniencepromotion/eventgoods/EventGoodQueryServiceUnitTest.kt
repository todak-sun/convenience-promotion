package io.todak.conveniencepromotion.eventgoods

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito


class EventGoodQueryServiceUnitTest {

    lateinit var service: EventGoodQueryService

    @BeforeEach
    fun beforeEach() {
        val repository: EventGoodsRepository = Mockito.mock(EventGoodsRepository::class.java)
        this.service = EventGoodQueryService(repository)

        BDDMockito.`when`(repository.findAll()).thenReturn(
            mutableListOf(EventGoodsEntity("화이팅", 1000, "https://image.todak.com/image01.png", "1+1", "GS25"))
        )

    }

    @Test
    fun fetchAllTest() {
        val fetched = this.service.fetchAll()
        assertEquals(1, fetched.size);
    }

}