package com.example.projectlogin.repository

sealed class DataBaseResult {
    object Success : DataBaseResult()
    data class Error(val message: String) : DataBaseResult()
}