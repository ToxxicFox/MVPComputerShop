package com.example.mvpcomputershop.domain.repository

import com.example.mvpcomputershop.domain.entity.CategoryEntity
import com.example.mvpcomputershop.domain.entity.ProductPageEntity
import io.reactivex.rxjava3.core.Single

interface ICatalogRepository {
    fun getCategories(): Single<CategoryEntity>
    fun getProducts(nextPage: Int): Single<ProductPageEntity>
    fun getProductsByFilters(categoryId: Int, nextPage: Int): Single<ProductPageEntity>
}