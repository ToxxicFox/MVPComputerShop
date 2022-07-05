package com.example.mvpcomputershop.data.network.api

import com.example.mvpcomputershop.domain.entity.CategoryEntity
import com.example.mvpcomputershop.domain.entity.ProductPageEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopApi {

    @GET("practice/shop/v1/categories")
    fun getCategories(): Single<CategoryEntity>

    @GET("practice/shop/v1/products")
    fun getProducts(@Query("page") page: Int): Single<ProductPageEntity>

    @GET("practice/shop/v1/products")
    fun getProductsByCategories(@Query("filter[category_id]") categoryId: Int,
                                        @Query("page") page: Int): Single<ProductPageEntity>

}