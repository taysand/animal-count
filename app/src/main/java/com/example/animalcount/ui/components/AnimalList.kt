package com.example.animalcount.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalcount.model.Animal
import com.example.animalcount.ui.theme.LargePadding
import com.example.animalcount.util.SampleAnimalList

@Composable
fun AnimalList(
    list: List<Animal>,
    increaseCount: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(LargePadding),
        modifier = modifier,
    ) {
        list.forEachIndexed { index, animal ->
            AnimalRow(
                animal = animal,
                increaseCount = { increaseCount(index) }
            )
        }
    }
}

@Preview
@Composable
fun AnimalListPreview() {
    AnimalList(
        list = SampleAnimalList,
        increaseCount = { },
    )
}
