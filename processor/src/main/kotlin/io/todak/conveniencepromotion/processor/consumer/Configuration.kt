package io.todak.conveniencepromotion.processor.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {

    @Bean("messageObjectMapper")
    fun messageObjectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        val kotlinModule = KotlinModule.Builder().build()
        objectMapper.registerModule(kotlinModule)
        return objectMapper
    }

}