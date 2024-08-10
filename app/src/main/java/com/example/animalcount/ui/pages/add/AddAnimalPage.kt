package com.example.animalcount.ui.pages.add

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AddAnimalPage(
    modifier: Modifier = Modifier,
    viewModel: AddAnimalPageViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val keyboardController = LocalSoftwareKeyboardController.current

    AddAnimalContents(
        name = uiState.name,
        emoji = uiState.emoji,
        onAnimalNameChange = { name ->
            viewModel.updateAnimalName(name)
        },
        onAnimalEmojiChange = { emoji ->
            viewModel.updateAnimalEmoji(emoji)
        },
        onAddButtonClick = {
            keyboardController?.hide()
            viewModel.addAnimal()
            navigateBack()
        },
        modifier = modifier,
    )
}
