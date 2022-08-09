package io.todak.conveniencepromotion.processor.domain

import org.springframework.data.jpa.repository.JpaRepository

interface EventGoodsRepository : JpaRepository<EventGoodsEntity, Long> {
}