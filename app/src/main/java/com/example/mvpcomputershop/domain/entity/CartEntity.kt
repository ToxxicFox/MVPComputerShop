package com.example.mvpcomputershop.domain.entity

data class CartEntity(
    val cartData: ArrayList<ItemEntity>,
    val cartMetaInfo: CartMetaInfoEntity
)