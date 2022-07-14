package com.example.mvpcomputershop.presentation.fragments.catalog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpcomputershop.App
import com.example.mvpcomputershop.databinding.FragmentCatalogBinding
import com.example.mvpcomputershop.domain.entity.CategoryData
import com.example.mvpcomputershop.domain.entity.ProductEntity
import com.example.mvpcomputershop.presentation.adapters.CategoryViewAdapter
import com.example.mvpcomputershop.presentation.adapters.ProductViewAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class CatalogFragment : MvpAppCompatFragment(), ICatalogView {

    @Inject
    lateinit var provider: Provider<CatalogPresenter>

    @InjectPresenter
    lateinit var presenter: CatalogPresenter

    @ProvidePresenter
    fun providePresenter(): CatalogPresenter = provider.get()

    private var initBinding: FragmentCatalogBinding? = null
    private val binding
        get() = initBinding

    private val productAdapter = ProductViewAdapter()
    private val categoryAdapter = CategoryViewAdapter()

    override fun onAttach(context: Context) {
        App.appInstance?.appComponent?.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapters()
        setListeners()
    }

    override fun displayProducts(items: ArrayList<ProductEntity>) {
        productAdapter.setUpdateList(items)
    }

    override fun displayCategories(items: ArrayList<CategoryData>) {
        categoryAdapter.setUpdateCategory(items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        initBinding = null
    }

    private fun setAdapters(){
        val productView = binding?.productsList
        productView?.layoutManager =
            GridLayoutManager(activity, 2)
        productView?.adapter = productAdapter

        val categoryView = binding?.filterList
        categoryView?.layoutManager =
            LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        categoryView?.adapter = categoryAdapter
    }

    private fun setListeners(){
        binding?.productsList?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)){
                    presenter.onLoadNextPage()
                }
            }

        })
    }
}