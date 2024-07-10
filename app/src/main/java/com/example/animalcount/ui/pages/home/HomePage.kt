package com.example.animalcount.ui.pages.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.animalcount.ui.components.AnimalList

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    viewModel: HomePageViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val animalList = uiState.animalList
    if (animalList.isNotEmpty()) {
        AnimalList(
            modifier = modifier,
            list = animalList,
        )
    } else {
        Text("empty state")
    }
}
