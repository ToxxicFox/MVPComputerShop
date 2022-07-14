package com.example.mvpcomputershop.presentation.fragments.catalog

import android.net.Uri
import android.util.Log
import com.example.mvpcomputershop.domain.usecases.catalog.GetCategoriesUseCase
import com.example.mvpcomputershop.domain.usecases.catalog.GetProductsByFilterUseCase
import com.example.mvpcomputershop.domain.usecases.catalog.GetProductsUseCase
import com.example.mvpcomputershop.presentation.di.navigation.FlowNavigation
import com.example.mvpcomputershop.presentation.navigation.catalog.ICatalogScreenOpener
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
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

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    private var currentPage = FIRST
    private var lastPage = LAST

    fun onLoadNextPage(){
        currentPage++
        if (currentPage <= lastPage) {
            getProduct(currentPage)
        }
    }

    private fun getProduct(nextPage: Int){
        getProductsUseCase.getProducts(nextPage)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                // show loader
            }
            .doFinally {
                // hide loader
            }
            .subscribe({
                viewState.displayProducts(it.data)
                val lastPageFromUri = Uri.parse(it.links.last).getQueryParameter("page")?.toInt()
                if (lastPageFromUri != null) {
                    lastPage = lastPageFromUri
                }
            }, { error ->
                error.printStackTrace()
                Log.e("CATALOG_PRODUCTS", error.toString())
            }).let(compositeDisposable::add)
    }

    private fun getCategories(){
        getCategoriesUseCase.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.displayCategories(it.data)
            }, { error ->
                error.printStackTrace()
                Log.e("CATALOG_CATEGORIES", error.toString())
            }).let(compositeDisposable::add)
    }

    init {
        getProduct(FIRST)
        getCategories()
    }

    companion object{
        const val FIRST = 1
        const val LAST = 99
    }

}