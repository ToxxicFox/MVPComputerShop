package com.example.mvpcomputershop.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpcomputershop.App
import com.example.mvpcomputershop.R
import com.example.mvpcomputershop.databinding.ActivityMainBinding
import com.example.mvpcomputershop.presentation.navigation.main.IScreenHolder
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screenHolder: IScreenHolder

    private val navigator = AppNavigator(this, R.id.container)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.appInstance?.appComponent?.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            router.replaceScreen(screenHolder.openCatalogFragment())
        }

        with(binding) {
            bottomNavigationView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_catalog -> {
                        router.replaceScreen(screenHolder.openCatalogFragment())
                        true
                    }
                    R.id.navigation_cart -> {
                        router.replaceScreen(screenHolder.openCartFragment())
                        true
                    }
                    R.id.navigation_profile -> {
                        router.replaceScreen(screenHolder.openProfileFragment())
                        true
                    }
                    else -> {
                        router.replaceScreen(screenHolder.openCatalogFragment())
                        true
                    }
                }
            }

            bottomNavigationView.setOnItemReselectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_catalog -> {
                        router.replaceScreen(screenHolder.openCatalogFragment())
                    }
                    R.id.navigation_cart -> {
                        router.replaceScreen(screenHolder.openCartFragment())
                    }
                    R.id.navigation_profile -> {
                        router.replaceScreen(screenHolder.openProfileFragment())
                    }
                    else -> {
                        router.replaceScreen(screenHolder.openCatalogFragment())
                    }
                }
            }
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}