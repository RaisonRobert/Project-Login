package com.example.projectlogin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectlogin.extension.isInvalidEmail
import com.example.projectlogin.repository.DataBaseRepository
import com.example.projectlogin.repository.DataBaseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: DataBaseRepository) : ViewModel() {
    val toastMensage = MutableLiveData<String?>()
    val verifyLoginSuccess = MutableLiveData<Boolean?>()

    init {
        toastMensage.value = null
        verifyLoginSuccess.value = null
    }

    suspend fun verifyLogin(email: String, password: String) {
        val result = when {
            email.isEmpty() -> DataBaseResult.Error("Digite o email")
            email.isInvalidEmail() -> DataBaseResult.Error("Email inválido")
            password.isEmpty() -> DataBaseResult.Error("Digite a senha")
            else -> DataBaseResult.Success
        }

        when (result) {
            is DataBaseResult.Success -> {
                // Operação de busca bem-sucedida
                // Exibir uma mensagem de sucesso, navegar para outra tela, etc.
                verifyLoginSuccess.value = true
            }

            is DataBaseResult.Error -> {
                // Operação de busca falhou
                toastMensage("${result.message}")
                verifyLoginSuccess.value = false
            }
        }
    }

    fun toastMensage(msg: String?) {
        toastMensage.value = msg
    }

}