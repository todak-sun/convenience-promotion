package io.todak.conveniencepromotion.processor.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "EVENT_GOODS")
class EventGoodsEntity(
    @Id
    @Column(name = "ID") val id: Long? = null,
    @Column(name = "PRODUCT_NAME", nullable = false) val productName: String,
    @Column(name = "PRICE", nullable = false) val price: Int = 0,
    @Column(name = "IMAGE_SRC") val imageSrc: String? = null,
    @Column(name = "EVENT_TYPE", nullable = false) val eventType: String,
    @Column(name = "STORE", nullable = false) val store: String,
    @Column(name = "CREATED_DATETIME") val createdDateTime: LocalDateTime = LocalDateTime.now()
) {

}