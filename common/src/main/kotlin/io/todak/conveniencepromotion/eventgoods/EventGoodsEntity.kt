package io.todak.conveniencepromotion.eventgoods

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "EVENT_GOODS")
class EventGoodsEntity(
    @Column(name = "PRODUCT_NAME", nullable = false)
    var productName: String,
    @Column(name = "PRICE", nullable = false) var price: Int,
    @Column(name = "IMAGE_SRC")
    var imageSrc: String,
    @Column(name = "EVENT_TYPE", nullable = false)
    var eventType: String,
    @Column(name = "STORE", nullable = false)
    var store: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    val id: Long?

    @CreatedDate
    @Column(name = "CREATED_DATETIME")
    lateinit var createdDateTime: LocalDateTime
        private set

    var eventMonth: String

    init {
        this.id = null
        val now = LocalDateTime.now()
        this.eventMonth = "${now.year}-${now.monthValue.toString().padStart(2, '0')}"
    }
}