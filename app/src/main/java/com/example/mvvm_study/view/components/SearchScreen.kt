package com.example.mvvm_study.view.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    searchQuery: MutableState<String>,
    onSearchButtonTapped: () -> Unit,
) {
    Row(modifier.fillMaxWidth()) {
        TextField(
            label = {
                Text("Input GitHub Account Name.")
            },
            value = searchQuery.value,
            onValueChange = { text ->
                searchQuery.value = text
            },
            modifier = Modifier.weight(1f)
        )

        Button(onClick = onSearchButtonTapped) {
            Text(text = "Search")
        }
    }
}