package com.example.projectlogin.model.bdroom

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projectlogin.model.entity.DataUser

@Database(entities = [DataUser::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun dataDao() : DataDao
}