package com.example.projectlogin.repository

import com.example.projectlogin.model.bdroom.DataDao
import javax.inject.Inject

class DataBaseRepository @Inject constructor(private val dataDao: DataDao) :
    DataBaseRepositoryInterface {
    override suspend fun save(email: String, password: String): DataBaseResult {
        TODO("Not yet implemented")
    }

    override suspend fun getEmail(email: String, password: String): DataBaseResult {
        TODO("Not yet implemented")
    }
}