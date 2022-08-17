package io.todak.conveniencepromotion.configuration

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager

@Configuration
class QueryDSLConfiguration {
    @Bean
    fun jpaQueryFactory(entityManager: EntityManager): JPAQueryFactory = JPAQueryFactory(entityManager)
}