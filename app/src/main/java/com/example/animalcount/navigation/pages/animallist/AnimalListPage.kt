package com.example.animalcount.navigation.pages.animallist

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.animalcount.ui.components.AnimalList

@Composable
fun AnimalListPage(
    modifier: Modifier = Modifier,
    viewModel: AnimalListPageViewModel = viewModel(),
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
