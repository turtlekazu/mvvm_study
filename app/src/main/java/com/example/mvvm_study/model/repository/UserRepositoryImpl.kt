package com.example.mvvm_study.model.repository

import com.example.mvvm_study.model.remote_data_source.RemoteDataSource
import com.example.mvvm_study.model.remote_data_source.dataclass.GitHubUser
import com.example.mvvm_study.model.repository.dataclass.NetworkImage
import com.example.mvvm_study.model.repository.dataclass.Url
import com.example.mvvm_study.model.repository.dataclass.User
import com.example.mvvm_study.model.repository.dataclass.UserId
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource): UserRepository {
    override suspend fun getUser(userName: String): User {
        return remoteDataSource.getGitHubUser(userName = userName).toUser()
    }
}

private fun GitHubUser.toUser(): User {
    return User(
        userId = UserId(value = id),
        name = name,
        avatarImage = NetworkImage(url = Url(value = avatarUrl)),
        blogUrl = Url(value = blog)
    )
}