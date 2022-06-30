package com.example.mvpcomputershop.presentation.fragments.signup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mvpcomputershop.App
import com.example.mvpcomputershop.databinding.FragmentSignUpBinding
import com.example.mvpcomputershop.presentation.model.signup.SignUpViewModel
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class SignUpFragment : MvpAppCompatFragment(), ISignUpView{

    @Inject
    lateinit var provider: Provider<SignUpPresenter>

    @InjectPresenter
    lateinit var presenter: SignUpPresenter

    @ProvidePresenter
    fun providePresenter(): SignUpPresenter = provider.get()

    private var initBinding: FragmentSignUpBinding? = null
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
        initBinding = FragmentSignUpBinding.inflate(inflater, container, false)
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
        binding?.btnSignUp?.setOnClickListener {
            presenter.signUp(getData())
        }
    }

    private fun getData(): SignUpViewModel {
        val email = binding?.signEmail?.text.toString()
        val password = binding?.signPassword?.text.toString()
        val confirmPassword = binding?.confirmSignPassword?.text.toString()
        return SignUpViewModel(email, password, confirmPassword)
    }


}