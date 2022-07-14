package com.example.mvpcomputershop.presentation.fragments.catalog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvpcomputershop.App
import com.example.mvpcomputershop.databinding.FragmentCatalogBinding
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        initBinding = null
    }
}