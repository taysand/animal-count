package com.example.animalcount.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalcount.model.Animal
import com.example.animalcount.ui.theme.MediumPadding
import com.example.animalcount.util.SampleAnimalList

@Composable
fun AnimalRow(
    animal: Animal,
    increaseCount: () -> Unit,
    deleteAnimal: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = MediumPadding,
            alignment = Alignment.CenterHorizontally
        ),
        modifier = modifier,
    ) {
        DeleteButton { deleteAnimal() }
        AnimalInfoCard(
            animal = animal,
            onClick = increaseCount,
        )
    }
}

@Preview
@Composable
fun AnimalRowPreview() {
    AnimalRow(
        animal = SampleAnimalList[0],
        deleteAnimal = { },
        increaseCount = { },
    )
}
