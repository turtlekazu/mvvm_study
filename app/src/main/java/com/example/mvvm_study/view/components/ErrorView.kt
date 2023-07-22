package com.example.mvvm_study.view.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ErrorView(modifier: Modifier = Modifier) {
    Text(text = "Failed Loading.")
}