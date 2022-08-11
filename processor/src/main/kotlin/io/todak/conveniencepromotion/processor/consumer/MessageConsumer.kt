package io.todak.conveniencepromotion.processor.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import io.todak.conveniencepromotion.processor.domain.EventGoods
import io.todak.conveniencepromotion.processor.domain.Service
import io.todak.conveniencepromotion.processor.logger
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import kotlin.system.exitProcess

@Component
class MessageConsumer(
    @Qualifier("messageObjectMapper") private val objectMapper: ObjectMapper,
    private val service: Service
) {

    private val log = logger()

    @RabbitListener(queues = ["CONVINIENCE.EVENT.GOODS.PROCESSOR"])
    fun receiveMessage(message: Message) {
        try {
            val goods = objectMapper.readValue(message.body, EventGoods::class.java)
            this.service.save(goods)
            log.info("goods: $goods")
        } catch (e: Exception) {
            e.printStackTrace()
            exitProcess(0)
        }
    }

}