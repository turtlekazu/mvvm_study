package com.example.mvvm_study

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CountUp(viewModel: CountViewModel = viewModel()) {
    val count by viewModel.count

    Column() {
        Text(text = "Count: $count")

        Button(onClick = { viewModel.onCountUpTapped() }) {
            Text("Count Up")
        }
    }
}