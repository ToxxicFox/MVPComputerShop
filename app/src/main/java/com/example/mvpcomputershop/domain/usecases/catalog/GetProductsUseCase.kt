package com.example.mvpcomputershop.domain.usecases.catalog

import com.example.mvpcomputershop.domain.repository.ICatalogRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ICatalogRepository
) {
    fun getProducts(nextPage: Int) = repository.getProducts(nextPage)
}