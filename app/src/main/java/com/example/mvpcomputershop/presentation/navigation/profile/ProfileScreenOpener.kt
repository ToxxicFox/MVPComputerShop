package com.example.mvpcomputershop.presentation.navigation.profile

import com.example.mvpcomputershop.presentation.fragments.login.LoginFragment
import com.example.mvpcomputershop.presentation.fragments.profile.ProfileFragment
import com.example.mvpcomputershop.presentation.fragments.signup.SignUpFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ProfileScreenOpener : IProfileScreenOpener {
    override fun openLoginFragment(): Screen = FragmentScreen { LoginFragment() }
    override fun openSignUpFragment(): Screen = FragmentScreen { SignUpFragment() }
    override fun openProfileFragment(): Screen = FragmentScreen { ProfileFragment() }
}