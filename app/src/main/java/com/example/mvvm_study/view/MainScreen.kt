package com.example.mvvm_study.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.mvvm_study.model.repository.dataclass.User
import com.example.mvvm_study.view.components.ErrorView
import com.example.mvvm_study.view.components.InitialView
import com.example.mvvm_study.view.components.LoadingView
import com.example.mvvm_study.view.components.SearchScreen
import com.example.mvvm_study.view.components.UserDetailView
import com.example.mvvm_study.viewmodel.MainViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
) {
    val uiState by mainViewModel.uiState

    Column(modifier.fillMaxWidth()) {
        SearchScreen(
            searchQuery = mainViewModel.searchQuery,
            onSearchButtonTapped = mainViewModel::onSearchTapped
        )

        when (uiState) {
            is MainViewModel.UiState.Initial -> {
                InitialView()
            }

            is MainViewModel.UiState.Loading -> {
                LoadingView()
            }

            is MainViewModel.UiState.Success -> {
                UserDetailView(user = uiState.requireUser())
            }

            is MainViewModel.UiState.Failure -> {
                ErrorView()
            }
        }
    }
}

private fun MainViewModel.UiState.requireUser(): User {
    if (this !is MainViewModel.UiState.Success) throw IllegalStateException("user is not loaded")
    return this.user
}