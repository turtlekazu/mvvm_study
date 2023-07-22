package com.example.mvvm_study.model.remote_data_source

import com.example.mvvm_study.model.remote_data_source.apiclient.ApiClient
import com.example.mvvm_study.model.remote_data_source.dataclass.GitHubUser
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiClient: ApiClient): RemoteDataSource {
    override suspend fun getGitHubUser(userName: String): GitHubUser {
        val response = apiClient.getGitHubUser(userName = userName)

        if (response.isSuccessful) {
            return requireNotNull(response.body())
        }
        throw HttpException()
    }
}

class HttpException: Throwable()