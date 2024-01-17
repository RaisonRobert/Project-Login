package com.example.projectlogin.model.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["email"], unique = true)])
data class DataUser(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,
    var email: String? = null,
    var password: String? = null
)
