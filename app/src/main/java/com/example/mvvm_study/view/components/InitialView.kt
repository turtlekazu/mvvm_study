package com.example.mvvm_study.view.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InitialView(modifier: Modifier = Modifier) {
    Text(
        text = "Please Search Something.",
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier
    )
}