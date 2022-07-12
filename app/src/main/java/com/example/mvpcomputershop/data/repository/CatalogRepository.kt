package com.example.mvpcomputershop.data.repository

import com.example.mvpcomputershop.data.network.api.ShopApi
import com.example.mvpcomputershop.domain.entity.CategoryEntity
import com.example.mvpcomputershop.domain.entity.ProductPageEntity
import com.example.mvpcomputershop.domain.repository.ICatalogRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CatalogRepository @Inject constructor(
    private val api: ShopApi
): ICatalogRepository {
    override fun getCategories(): Single<CategoryEntity> {
        return api.getCategories()
    }

    override fun getProducts(nextPage: Int): Single<ProductPageEntity> {
        return api.getProducts(nextPage)
    }

    override fun getProductsByFilters(categoryId: Int, nextPage: Int): Single<ProductPageEntity> {
        return api.getProductsByCategories(categoryId, nextPage)
    }

}