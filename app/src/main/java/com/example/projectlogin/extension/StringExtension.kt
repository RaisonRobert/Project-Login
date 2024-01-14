package com.example.projectlogin.extension

import android.util.Patterns

// Função para verificar se o email é válido usando a classe Patterns do Android
fun String?.isInvalidEmail(): Boolean {
    return this.isNullOrBlank() || !Patterns.EMAIL_ADDRESS.matcher(this).matches()
}