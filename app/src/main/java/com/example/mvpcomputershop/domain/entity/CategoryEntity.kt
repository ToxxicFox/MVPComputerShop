package com.example.mvpcomputershop.domain.entity

data class CategoryEntity(
    val data: ArrayList<CategoryData>
)

data class CategoryData(
    val id: Int,
    val title: String,
    val info: String,
    val link: String
)