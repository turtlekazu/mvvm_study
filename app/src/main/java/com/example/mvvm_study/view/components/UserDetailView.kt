package com.example.mvvm_study.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mvvm_study.model.repository.dataclass.User

@Composable
fun UserDetailView(
    modifier: Modifier = Modifier,
    user: User,
) {
    Column {
        Text(text = user.userId.value.toString())
        Text(text = user.name)
        Text(text = user.avatarImage.url.value)
        Text(text = user.blogUrl.value)
    }
}