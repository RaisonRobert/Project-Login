package com.example.projectlogin.repository

interface DataBaseRepositoryInterface {
    suspend fun save(email: String, password: String): DataBaseResult
    suspend fun getEmail(email: String, password: String): DataBaseResult
}