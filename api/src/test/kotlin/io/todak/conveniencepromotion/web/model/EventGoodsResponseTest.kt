package io.todak.conveniencepromotion.web.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class EventGoodsResponseTest {

    @DisplayName("EventGoodsResponse를 만들어보자.")
    @Test
    fun createTest() {
        val eventGoodsResponse = EventGoodsResponse("1+1", 1000, "핫바")
        assertEquals(eventGoodsResponse.store, "1+1")
        assertEquals(eventGoodsResponse.price, 1000)
        assertEquals(eventGoodsResponse.productName, "핫바")
    }

}

