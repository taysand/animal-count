package com.example.animalcount.ui.pages.add

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalcount.R

@Composable
fun AddAnimalContents(
    animalName: String,
    modifier: Modifier = Modifier,
    onAnimalNameChange: (String) -> Unit,
    onAddButtonClick: () -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        TextField(
            value = animalName,
            singleLine = true,
            onValueChange = onAnimalNameChange,
            placeholder = {
                Text(stringResource(id = R.string.animal_name))
            },
        )
        Button(
            onClick = onAddButtonClick,
            enabled = animalName.isNotEmpty(),
        ) {
            Text(stringResource(id = R.string.add_animal))
        }
    }
}

@Preview
@Composable
fun AddAnimalPageContentsPreview() {
    AddAnimalContents(
        animalName = "",
        onAnimalNameChange = { },
        onAddButtonClick = { }
    )
}
