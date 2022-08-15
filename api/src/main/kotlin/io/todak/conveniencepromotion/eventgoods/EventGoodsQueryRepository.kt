package io.todak.conveniencepromotion.eventgoods

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository


@Repository
class EventGoodsQueryRepository(private val qf: JPAQueryFactory) {


    fun queryEventGoods(){
        
//        this.qf.select()
//            .from(QEventGoods)
    }

}