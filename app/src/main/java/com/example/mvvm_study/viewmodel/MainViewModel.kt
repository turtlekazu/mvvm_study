package com.example.mvvm_study.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_study.model.repository.UserRepository
import com.example.mvvm_study.model.repository.dataclass.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    sealed class UiState {
        object Initial : UiState()

        object Loading : UiState()

        data class Success(val user: User) : UiState()

        object Failure : UiState()
    }

    val uiState: MutableState<UiState> = mutableStateOf(UiState.Initial)

    val searchQuery: MutableState<String> = mutableStateOf("")

    fun onSearchTapped() {
        val searchQuery = searchQuery.value

        viewModelScope.launch {
            uiState.value = UiState.Loading
            runCatching {
                userRepository.getUser(userName = searchQuery)
            }.onSuccess {
                uiState.value = UiState.Success(user = it)
            }.onFailure {
                uiState.value = UiState.Failure
            }
        }
    }
}