package com.example.mvpcomputershop.presentation.fragments.catalog

import com.example.mvpcomputershop.domain.entity.CategoryData
import com.example.mvpcomputershop.domain.entity.ProductEntity
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ICatalogView: MvpView {

    @StateStrategyType(AddToEndStrategy::class)
    fun displayProducts(items: ArrayList<ProductEntity>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun displayCategories(items: ArrayList<CategoryData>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setFilter()

}