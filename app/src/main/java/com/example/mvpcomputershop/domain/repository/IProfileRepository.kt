package com.example.mvpcomputershop.domain.repository

import com.example.mvpcomputershop.domain.entity.OrderEntity
import io.reactivex.rxjava3.core.Single

interface IProfileRepository {
    fun getOrders(token: String): Single<OrderEntity>
}