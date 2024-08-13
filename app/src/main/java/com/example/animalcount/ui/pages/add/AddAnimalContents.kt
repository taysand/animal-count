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
    name: String,
    emoji: String,
    onAnimalNameChange: (String) -> Unit,
    onAnimalEmojiChange: (String) -> Unit,
    onAddButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        TextField(
            value = name,
            singleLine = true,
            onValueChange = onAnimalNameChange,
            placeholder = {
                Text(stringResource(id = R.string.name))
            },
        )
        TextField(
            value = emoji,
            singleLine = true,
            onValueChange = onAnimalEmojiChange,
            placeholder = {
                Text(stringResource(id = R.string.emoji))
            },
        )
        Button(
            onClick = onAddButtonClick,
            enabled = name.isNotEmpty(),
        ) {
            Text(stringResource(id = R.string.add_animal))
        }
    }
}

@Preview
@Composable
fun AddAnimalPageContentsPreview() {
    AddAnimalContents(
        name = "",
        emoji = "",
        onAnimalNameChange = { },
        onAnimalEmojiChange = { },
        onAddButtonClick = { },
    )
}
