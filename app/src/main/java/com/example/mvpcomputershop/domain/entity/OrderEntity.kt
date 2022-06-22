package com.example.mvpcomputershop.domain.entity

data class OrderEntity(
    val order: OrderData
)

data class OrderData(
    val id: Int,
    val status: String,
    val address: String,
    val name: String,
    val phoneNumber: String,
    val totalOrderPrice: Int,
    val discount: Int,
    val totalPriceWithDiscount: Int,
    val items: ArrayList<ItemEntity>
)