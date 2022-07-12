package com.example.mvpcomputershop.domain.usecases.catalog

import com.example.mvpcomputershop.domain.repository.ICatalogRepository
import javax.inject.Inject

class GetProductsByFilterUseCase @Inject constructor (
    private val repository: ICatalogRepository
) {
    fun getProductsByFilter(categoryId: Int, nextPage: Int) =
        repository.getProductsByFilters(categoryId, nextPage)
}