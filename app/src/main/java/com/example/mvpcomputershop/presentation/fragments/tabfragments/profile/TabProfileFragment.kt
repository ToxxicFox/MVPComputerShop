package com.example.mvpcomputershop.presentation.fragments.tabfragments.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mvpcomputershop.App
import com.example.mvpcomputershop.R
import com.example.mvpcomputershop.databinding.FragmentTabProfileBinding
import com.example.mvpcomputershop.presentation.di.navigation.ProfileNavigation
import com.example.mvpcomputershop.presentation.navigation.profile.IProfileScreenOpener
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject


class TabProfileFragment : Fragment() {

    @Inject
    @ProfileNavigation
    lateinit var navigatorTabProfileHolder: NavigatorHolder

    @Inject
    @ProfileNavigation
    lateinit var routerProfile: Router

    @Inject
    @ProfileNavigation
    lateinit var screenOpenProfile: IProfileScreenOpener

    private val navigator: Navigator by lazy {
        AppNavigator(requireActivity(), R.id.tab_profile_nav_container)
    }

    private var initBinding: FragmentTabProfileBinding? = null
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
        initBinding = FragmentTabProfileBinding.inflate(inflater, container, false)
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
}