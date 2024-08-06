package com.example.animalcount.ui.pages.add

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.animalcount.R
import com.example.animalcount.ui.pages.home.HomePageViewModel

@Composable
fun AddAnimalPage(
    modifier: Modifier = Modifier,
    viewModel: AddAnimalPageViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        Button(
            onClick = {
                viewModel.addAnimal("new animal")
                navigateBack()
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
