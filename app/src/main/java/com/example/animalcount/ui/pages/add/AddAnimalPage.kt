package com.example.animalcount.ui.pages.add

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.animalcount.R

@Composable
fun AddAnimalPage(
    modifier: Modifier = Modifier,
    viewModel: AddAnimalPageViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier,
    ) {
        TextField(
            value = uiState.name,
            singleLine = true,
            onValueChange = { name ->
                viewModel.updateAnimalName(name)
            },
            placeholder = {
                Text(stringResource(id = R.string.animal_name))
            },
        )
        Button(
            onClick = {
                if (uiState.name.isNotEmpty()) {
                    keyboardController?.hide()
                    viewModel.addAnimal()
                    navigateBack()
                }
            },
        ) {
            Text(stringResource(id = R.string.add_animal))
        }
    }
}


@Preview
@Composable
fun AddAnimalPagePreview() {
    AddAnimalPage(navigateBack = { })
}
