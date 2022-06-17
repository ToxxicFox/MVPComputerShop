package com.example.mvpcomputershop.domain.entity

data class ItemEntity(
    val id: Int,
    val product: ProductEntity,
    val quantity: Int
)