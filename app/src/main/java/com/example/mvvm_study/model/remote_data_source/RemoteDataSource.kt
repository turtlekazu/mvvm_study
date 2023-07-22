package com.example.mvvm_study.model.remote_data_source

import com.example.mvvm_study.model.remote_data_source.dataclass.GitHubUser

interface RemoteDataSource {
    suspend fun getGitHubUser(userName: String): GitHubUser
}