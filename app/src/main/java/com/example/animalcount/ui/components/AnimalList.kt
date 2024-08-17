package com.example.animalcount.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalcount.model.Animal
import com.example.animalcount.ui.theme.MediumPadding
import com.example.animalcount.util.SampleAnimalList

@Composable
fun AnimalList(
    list: List<Animal>,
    increaseCount: (Int) -> Unit,
    openDetailPage: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier.padding(MediumPadding),
        columns = GridCells.Fixed(count = 2),
        horizontalArrangement = Arrangement.spacedBy(MediumPadding),
        verticalArrangement = Arrangement.spacedBy(MediumPadding),
    ) {
        itemsIndexed(
            items = list,
            key = { _, animal ->
                animal.id
            }
        ) { index, animal ->
            AnimalInfoCard(
                animal = animal,
                onClick = { increaseCount(index) },
                onLongClick = { openDetailPage(animal.id) },
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
        openDetailPage = { },
    )
}
