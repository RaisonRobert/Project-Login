package com.example.projectlogin.model.bdroom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.projectlogin.model.entity.DataUser

@Dao
interface DataDao {
    @Insert
    fun save(vararg dados: DataUser)

    @Query("SELECT * FROM DataUser WHERE email = :email AND password =:password")
    fun getEmail(email: String, password: String): DataUser?

    @Delete
    fun delete(vararg dados: DataUser)

    @Update
    fun updateUser(dados: DataUser)
}