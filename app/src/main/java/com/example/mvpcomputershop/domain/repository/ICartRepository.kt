package com.example.mvpcomputershop.domain.repository

import com.example.mvpcomputershop.domain.entity.CartEntity
import com.example.mvpcomputershop.domain.entity.ItemEntity
import io.reactivex.rxjava3.core.Single

interface ICartRepository {
    fun getCart(token: String): Single<CartEntity>

    fun changeQuantityItemInCart(token: String, basketItemId: Int, quantity: ItemEntity):
            Single<CartEntity>

    fun deleteItemFromBasket(token: String, basketItemId: Int):
            Single<CartEntity>
}