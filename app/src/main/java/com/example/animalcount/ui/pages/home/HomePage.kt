package com.example.animalcount.ui.pages.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.animalcount.R
import com.example.animalcount.ui.components.AnimalList

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    viewModel: HomePageViewModel = hiltViewModel(),
    openDetailPage: (String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val animalList = uiState.animalList

    if (animalList.isNotEmpty()) {
        AnimalList(
            modifier = modifier,
            list = animalList,
            increaseCount = { index ->
                viewModel.increaseCount(index)
            },
            openDetailPage = { animalId ->
                openDetailPage(animalId)
            }
        )
    } else {
        Text(stringResource(id = R.string.no_animals))
    }
}
