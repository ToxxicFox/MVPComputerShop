package com.example.mvpcomputershop.domain.entity

data class OrderEntity(
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