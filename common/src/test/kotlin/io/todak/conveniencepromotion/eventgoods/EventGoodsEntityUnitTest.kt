package io.todak.conveniencepromotion.eventgoods

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class EventGoodsEntityUnitTest {

    @Test
    fun test() {
        val entity = EventGoodsEntity( "productName", 0, "http://www.naver.com", "1+1", "GS25")
        assertNull(entity.id)
    }
}

