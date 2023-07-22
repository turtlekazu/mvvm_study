package com.example.mvvm_study.model.repository.dataclass

data class User(
    val userId: UserId,
    val name: String,
    val avatarImage: NetworkImage,
    val blogUrl: Url,
)