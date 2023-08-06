package com.example.mvpcomputershop.presentation.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mvpcomputershop.App
import com.example.mvpcomputershop.R
import com.example.mvpcomputershop.databinding.ActivityMainBinding
import com.example.mvpcomputershop.presentation.navigation.main.BackButtonListener
import com.example.mvpcomputershop.presentation.navigation.main.ScreenFactory
import com.example.mvpcomputershop.presentation.navigation.main.TabKeys
import com.github.terrakok.cicerone.Router
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
        val currentFragment = fm.fragments.find { it.isVisible }
        val newFragment = fm.findFragmentByTag(tab.name)
        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return
        val transaction = fm.beginTransaction()
        if (newFragment == null) {
            transaction.add(
                R.id.container,
                ScreenFactory.createTab(tab).createFragment(fm.fragmentFactory), tab.name
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
        val fragment: Fragment? = fm.fragments.find { it.isVisible }
        if (fragment != null && fragment is BackButtonListener
            && (fragment as BackButtonListener).onBackPressed()) {
            return
        } else {
            presenter.onBackPressed()
        }
    }
}