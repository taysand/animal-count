package com.example.animalcount.ui.pages.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AnimalDetailPage(
    modifier: Modifier = Modifier,
    viewModel: AnimalDetailPageViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    uiState.animal?.let {
        Text("animal detail page for ${it.name}")
    }
}
