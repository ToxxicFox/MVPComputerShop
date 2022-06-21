package com.example.mvpcomputershop.domain.entity

data class ProductPageEntity(
    val data: ArrayList<ProductEntity>,
    val links: Links,
    val meta: Meta
)

data class Links(
    val first: String,
    val last: String,
    val next: String?,
    val prev: Any
)

data class Meta(
    val currentPage: Int,
    val from: Int,
    val lastPage: Int,
    val links: List<Link>,
    val path: String,
    val perPage: Int,
    val to: Int,
    val total: Int
)

data class Link(
    val active: Boolean,
    val label: String,
    val url: Any
)