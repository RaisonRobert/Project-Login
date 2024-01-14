package com.example.projectlogin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.projectlogin.R
import com.example.projectlogin.databinding.FragmentLoginBinding
import com.example.projectlogin.util.Utils.dismissProgressDialog
import com.example.projectlogin.util.Utils.showProgressDialog
import com.example.projectlogin.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val mViewModel: LoginViewModel by viewModels()
    private lateinit var email: String
    private lateinit var password: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupLayoutClick()
        setupLiveDataViewModel()
        return root
    }

    private fun setupLayoutClick() {
        binding.txtCreateAcountLogin.setOnClickListener {
            //TODO
        }
        binding.btnLogin.setOnClickListener {
            showProgressDialog(requireContext(), "Aguarde...")
            email = binding.fieldUserNameLogin.text.toString().trim()
            password = binding.fieldPasswordLogin.text.toString().trim()
            lifecycleScope.launch {
                mViewModel.verifyLogin(email, password)
            }
        }
    }

    private fun setupLiveDataViewModel() {
        mViewModel.toastMensage.observe(viewLifecycleOwner) { mensage ->
            mensage?.let {
                dismissProgressDialog()
                Toast.makeText(requireContext(), mensage, Toast.LENGTH_SHORT).show()
                mViewModel.toastMensage(null)
            }
        }

        mViewModel.verifyLoginSuccess.observe(viewLifecycleOwner) { login ->
            login?.let {
                dismissProgressDialog()
                findNavController().navigate(R.id.action_login_to_home).takeIf { login }
            }
        }
    }
}