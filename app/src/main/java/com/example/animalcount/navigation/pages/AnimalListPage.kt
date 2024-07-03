package com.example.animalcount.navigation.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animalcount.model.Animal
import com.example.animalcount.ui.components.AnimalRow

@Composable
fun AnimalListPage(
    modifier: Modifier = Modifier
) {
    val animalList = listOf(
        Animal(name = "Cat"),
        Animal(name = "Cow"),
        Animal(name = "Crab"),
        Animal(name = "Dog"),
        Animal(name = "Seal"),
        Animal(name = "Sea Lion"),
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier,
    ) {
        for (animal in animalList) {
            AnimalRow(animal)
        }
    }
}
