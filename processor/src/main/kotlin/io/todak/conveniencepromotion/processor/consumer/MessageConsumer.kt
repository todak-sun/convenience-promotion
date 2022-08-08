package io.todak.conveniencepromotion.processor.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import io.todak.conveniencepromotion.processor.domain.EventGoods
import org.slf4j.LoggerFactory
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import kotlin.system.exitProcess

@Component
class MessageConsumer(@Qualifier("messageObjectMapper") val objectMapper: ObjectMapper) {

    private val log = LoggerFactory.getLogger(javaClass)

    @RabbitListener(queues = ["CONVINIENCE.EVENT.GOODS.PROCESSOR"])
    fun receiveMessage(message: Message) {
        try {
            val goods = objectMapper.readValue(message.body, EventGoods::class.java)
            log.info("goods: ${goods}")
        } catch (e: Exception) {
            e.printStackTrace()
            exitProcess(0)
        }


    }

}