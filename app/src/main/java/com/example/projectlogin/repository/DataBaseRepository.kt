package com.example.projectlogin.repository

import android.database.sqlite.SQLiteConstraintException
import com.example.projectlogin.model.bdroom.DataDao
import com.example.projectlogin.model.entity.DataUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataBaseRepository @Inject constructor(private val dataDao: DataDao) :
    DataBaseRepositoryInterface {
    override suspend fun save(email: String, password: String): DataBaseResult {
       return runCatching {
           withContext(Dispatchers.IO){
               dataDao.save(DataUser(email = email, password = password))
               DataBaseResult.Success
           }
       }.getOrElse {e->
            when(e){
                is SQLiteConstraintException -> {
                    if (e.message?.contains("UNIQUE constraint failed: DataUser.email") == true){
                        DataBaseResult.Error("Usario já cadastrado")
                    }else{
                        DataBaseResult.Error("Erro no SQLite")
                    }
                }
                else -> DataBaseResult.Error(e.message ?: "Erro desconhecido")
            }
       }
    }

    override suspend fun getEmail(email: String, password: String): DataBaseResult {
        return try {
            withContext(Dispatchers.IO){
                val user = dataDao.getEmail(email, password)
                user?.let {
                    DataBaseResult.Success
                } ?: DataBaseResult.Error("Usario não encontrado")
            }
        }catch (e:Exception){
            DataBaseResult.Error("Erro no banco de dados")
        }
    }
}