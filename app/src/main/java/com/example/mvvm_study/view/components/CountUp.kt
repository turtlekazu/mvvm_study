package com.example.mvvm_study.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvm_study.viewmodel.CountViewModel

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