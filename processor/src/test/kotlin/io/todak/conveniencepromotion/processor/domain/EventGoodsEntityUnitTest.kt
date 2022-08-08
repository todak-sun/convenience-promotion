package io.todak.conveniencepromotion.processor.domain

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class EventGoodsEntityUnitTest {

    @Test
    fun test() {
        val entity = EventGoodsEntity(null, "productName", 0, null, "1+1", "GS25")
        assertNull(entity.id)
    }
}

