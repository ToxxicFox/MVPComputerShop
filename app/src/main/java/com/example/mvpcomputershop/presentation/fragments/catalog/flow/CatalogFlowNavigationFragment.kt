package com.example.mvpcomputershop.presentation.fragments.catalog.flow

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvpcomputershop.App
import com.example.mvpcomputershop.R
import com.example.mvpcomputershop.databinding.FragmentCatalogFlowNavigationBinding
import com.example.mvpcomputershop.presentation.di.navigation.FlowNavigation
import com.example.mvpcomputershop.presentation.navigation.catalog.ICatalogScreenOpener
import com.example.mvpcomputershop.presentation.navigation.main.BackButtonListener
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject


class CatalogFlowNavigationFragment : Fragment(), BackButtonListener {
    @Inject
    @FlowNavigation
    lateinit var navigatorTabProfileHolder: NavigatorHolder

    @Inject
    @FlowNavigation
    lateinit var routerProfile: Router

    @Inject
    @FlowNavigation
    lateinit var screenOpenCatalog: ICatalogScreenOpener

    private val navigator: Navigator by lazy {
        AppNavigator(requireActivity(), R.id.tab_catalog_nav_container, childFragmentManager)
    }

    private var initBinding: FragmentCatalogFlowNavigationBinding? = null
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
        initBinding = FragmentCatalogFlowNavigationBinding.inflate(inflater, container, false)
        return  binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (childFragmentManager.findFragmentById(R.id.tab_catalog_nav_container) == null) {
            routerProfile.replaceScreen(screenOpenCatalog.openCatalogFragment())
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorTabProfileHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorTabProfileHolder.removeNavigator()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        initBinding = null
    }

    override fun onBackPressed(): Boolean {
        val fragment = childFragmentManager.findFragmentById(R.id.tab_catalog_nav_container)
        return if (fragment != null && fragment is BackButtonListener
            && (fragment as BackButtonListener).onBackPressed()) {
            true
        } else {
            routerProfile.exit()
            true
        }
    }
}