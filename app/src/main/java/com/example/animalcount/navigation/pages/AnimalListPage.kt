package com.example.animalcount.navigation.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalcount.model.Animal
import com.example.animalcount.ui.components.AnimalRow
import com.example.animalcount.ui.theme.LargePadding
import com.example.animalcount.util.SampleAnimalList

@Composable
fun AnimalListPage(
    list: List<Animal>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(LargePadding),
        modifier = modifier,
    ) {
        for (animal in list) {
            AnimalRow(animal)
        }
    }
}

@Preview
@Composable
fun AnimalListPagePreview() {
    AnimalListPage(SampleAnimalList)
}
