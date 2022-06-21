package com.example.mvpcomputershop.domain.repository

import com.example.mvpcomputershop.domain.entity.CartEntity
import com.example.mvpcomputershop.domain.entity.ProductToCartEntity
import io.reactivex.rxjava3.core.Single

interface IProductRepository {
    fun addItemToBasket(token: String, item: ProductToCartEntity): Single<CartEntity>
}