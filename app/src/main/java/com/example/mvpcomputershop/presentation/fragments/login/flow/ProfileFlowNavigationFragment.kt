package com.example.mvpcomputershop.presentation.fragments.login.flow

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvpcomputershop.App
import com.example.mvpcomputershop.R
import com.example.mvpcomputershop.databinding.FragmentProfileFlowNavigationBinding
import com.example.mvpcomputershop.presentation.di.navigation.FlowNavigation
import com.example.mvpcomputershop.presentation.navigation.main.BackButtonListener
import com.example.mvpcomputershop.presentation.navigation.profile.IProfileScreenOpener
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatFragment
import javax.inject.Inject

class ProfileFlowNavigationFragment : MvpAppCompatFragment(), IProfileFlowNavigationView,
    BackButtonListener {

    @Inject
    @FlowNavigation
    lateinit var navigatorTabProfileHolder: NavigatorHolder

    @Inject
    @FlowNavigation
    lateinit var routerProfile: Router

    @Inject
    @FlowNavigation
    lateinit var screenOpenProfile: IProfileScreenOpener

    private val navigator: Navigator by lazy {
        AppNavigator(requireActivity(), R.id.tab_profile_nav_container, childFragmentManager)
    }

    private var initBinding: FragmentProfileFlowNavigationBinding? = null
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
        initBinding = FragmentProfileFlowNavigationBinding.inflate(inflater, container, false)
        return  binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (childFragmentManager.findFragmentById(R.id.tab_profile_nav_container) == null) {
            routerProfile.replaceScreen(screenOpenProfile.openLoginFragment())
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
        val fragment = childFragmentManager.findFragmentById(R.id.tab_profile_nav_container)
        return if (fragment != null && fragment is BackButtonListener
            && (fragment as BackButtonListener).onBackPressed()) {
            true
        } else {
            routerProfile.exit()
            true
        }
    }
}