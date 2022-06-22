package com.example.mvpcomputershop.domain.entity

data class ProductEntity(
    val id: Int,
    val category: CategoryEntity,
    val vendor: VendorEntity,
    val title: String,
    val info: String,
    val img: String,
    val price: Int,
    val discount: Int,
    val priceWithDiscount: Int,
    val link: String
)