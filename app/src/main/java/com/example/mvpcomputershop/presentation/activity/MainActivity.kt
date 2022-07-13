package com.example.mvpcomputershop.presentation.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mvpcomputershop.App
import com.example.mvpcomputershop.R
import com.example.mvpcomputershop.databinding.ActivityMainBinding
import com.example.mvpcomputershop.presentation.fragments.cart.flow.CartFragmentFlowNavigationFragment
import com.example.mvpcomputershop.presentation.fragments.catalog.flow.CatalogFlowNavigationFragment
import com.example.mvpcomputershop.presentation.fragments.login.flow.ProfileFlowNavigationFragment
import com.example.mvpcomputershop.presentation.navigation.main.BackButtonListener
import com.example.mvpcomputershop.presentation.navigation.main.TabKeys
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var router: Router

    @InjectPresenter
    lateinit var presenter: MainActivityPresenter

    @ProvidePresenter
    fun initMainPresenter() = MainActivityPresenter(router)

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appInstance?.appComponent?.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            selectTab(TabKeys.CATALOG)
        }

        with(binding) {
            bottomNavigationView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_catalog -> {
                        selectTab(TabKeys.CATALOG)
                        true
                    }
                    R.id.navigation_cart -> {
                        selectTab(TabKeys.CART)
                        true
                    }
                    R.id.navigation_profile -> {
                        selectTab(TabKeys.PROFILE)
                        true
                    }
                    else -> {
                        selectTab(TabKeys.CATALOG)
                        false
                    }
                }
            }
        }
    }

    private fun selectTab(tab: TabKeys) {
        val fm = supportFragmentManager
        var currentFragment: Fragment? = null
        val fragments = fm.fragments
        for (f in fragments) {
            if (f.isVisible) {
                currentFragment = f
                break
            }
        }
        val newFragment = fm.findFragmentByTag(tab.name)
        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return
        val transaction = fm.beginTransaction()
        if (newFragment == null) {
            transaction.add(
                R.id.container,
                createTab(tab).createFragment(fm.fragmentFactory), tab.name
            )
        }
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }
        if (newFragment != null) {
            transaction.show(newFragment)
        }
        transaction.commitNow()
    }

    override fun onBackPressed() {
        val fm = supportFragmentManager
        var fragment: Fragment? = null
        val fragments = fm.fragments
        for (f in fragments) {
            if (f.isVisible) {
                fragment = f
                break
            }
        }
        if (fragment != null && fragment is BackButtonListener
            && (fragment as BackButtonListener).onBackPressed()) {
            return
        } else {
            presenter.onBackPressed()
        }
    }

    private fun createTab(tab: TabKeys) = FragmentScreen {
        when(tab) {
            TabKeys.CATALOG -> {
                CatalogFlowNavigationFragment()
            }
            TabKeys.PROFILE -> {
                ProfileFlowNavigationFragment()
            }
            TabKeys.CART -> {
                CartFragmentFlowNavigationFragment()
            }
        }
    }
}