package com.example.mvpcomputershop.presentation.fragments.catalog

import com.example.mvpcomputershop.domain.entity.CategoryData
import com.example.mvpcomputershop.domain.entity.ProductEntity
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ICatalogView: MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun displayProducts(items: ArrayList<ProductEntity>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun displayCategories(items: ArrayList<CategoryData>)

}