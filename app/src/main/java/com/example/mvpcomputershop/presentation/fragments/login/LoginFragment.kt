package com.example.mvpcomputershop.presentation.fragments.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mvpcomputershop.App
import com.example.mvpcomputershop.R
import com.example.mvpcomputershop.data.network.api.AuthApi
import com.example.mvpcomputershop.databinding.FragmentLoginBinding
import com.example.mvpcomputershop.presentation.fragments.signup.SignUpFragment
import com.example.mvpcomputershop.presentation.model.login.LoginViewModel
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class LoginFragment : MvpAppCompatFragment(), ILoginView {

    @Inject
    lateinit var provider: Provider<LoginPresenter>

    @Inject
    lateinit var api: AuthApi

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun providePresenter(): LoginPresenter = provider.get()

    private var initBinding: FragmentLoginBinding? = null
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
        initBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        initBinding = null
    }

    override fun showMessage(token: String) {
        Toast.makeText(requireContext(), token, Toast.LENGTH_SHORT).show()
    }

    private fun setListeners() {
        binding?.btnLogin?.setOnClickListener {
            presenter.login(getData())
        }

        binding?.navToSignUp?.setOnClickListener {
            openSignUpFragment()
        }
    }

    private fun getData(): LoginViewModel {
        val email = binding?.signEmail?.text.toString()
        val password = binding?.signPasswordLogin?.text.toString()
        return LoginViewModel(email, password)
    }

    private fun openSignUpFragment() {
        activity?.supportFragmentManager?.apply {
            beginTransaction()
                .replace(R.id.container, SignUpFragment())
                .addToBackStack("")
                .commit()
        }
    }

}