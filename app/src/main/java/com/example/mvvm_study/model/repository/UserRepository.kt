package com.example.mvvm_study.model.repository

import com.example.mvvm_study.model.repository.dataclass.User

interface UserRepository {
    suspend fun getUser(userName: String): User
}