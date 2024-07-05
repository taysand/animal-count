package com.example.animalcount.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalcount.model.Animal
import com.example.animalcount.ui.theme.LargeFont
import com.example.animalcount.util.SampleAnimalList

@Composable
fun AnimalInfo(
    count: Int,
    animal: Animal,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.titleLarge.copy(fontSize = LargeFont),
        )
        Text(
            text = animal.name,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Preview
@Composable
fun AnimalInfoPreview() {
    AnimalInfo(count = 3, animal = SampleAnimalList[0])
}
