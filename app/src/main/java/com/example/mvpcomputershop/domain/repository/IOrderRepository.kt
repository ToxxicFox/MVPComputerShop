package com.example.mvpcomputershop.domain.repository

import com.example.mvpcomputershop.domain.entity.OrderEntity
import com.example.mvpcomputershop.domain.entity.OrderRegistrationEntity
import io.reactivex.rxjava3.core.Single

interface IOrderRepository {
    fun createOrder(token: String, order: OrderRegistrationEntity): Single<OrderEntity>
    fun getOrderById(token: String, orderId: Int): Single<OrderEntity>
}