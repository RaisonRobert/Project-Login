package com.example.projectlogin.configapp

import android.app.Application
import androidx.room.Room
import com.example.projectlogin.model.bdroom.AppDatabase
import com.example.projectlogin.model.bdroom.DataDao
import com.example.projectlogin.repository.DataBaseRepository
import com.example.projectlogin.repository.DataBaseRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object AppModule {
        @Provides
        fun provideDatabase(application: Application): AppDatabase{
            return Room.databaseBuilder(application, AppDatabase::class.java, "login_db")
                .fallbackToDestructiveMigration().build()
        }
    @Provides
    fun provideUserDao(database: AppDatabase): DataDao{
        return database.dataDao()
    }
    @Provides
    fun provideDataBaseRepository(dataDao: DataDao): DataBaseRepositoryInterface{
        return DataBaseRepository(dataDao)
    }
}


