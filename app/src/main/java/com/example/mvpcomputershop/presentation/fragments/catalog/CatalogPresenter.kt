package com.example.mvpcomputershop.presentation.fragments.catalog

import com.example.mvpcomputershop.domain.usecases.catalog.GetCategoriesUseCase
import com.example.mvpcomputershop.domain.usecases.catalog.GetProductsByFilterUseCase
import com.example.mvpcomputershop.domain.usecases.catalog.GetProductsUseCase
import com.example.mvpcomputershop.presentation.di.navigation.FlowNavigation
import com.example.mvpcomputershop.presentation.navigation.catalog.ICatalogScreenOpener
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class CatalogPresenter @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getProductsByFilterUseCase: GetProductsByFilterUseCase,
    @FlowNavigation
    private val router: Router,
    @FlowNavigation
    private val screenOpener: ICatalogScreenOpener
): MvpPresenter<ICatalogView>() {

    var currentPage = 1

    fun onLoadNextPage() {
        currentPage++

    }

}