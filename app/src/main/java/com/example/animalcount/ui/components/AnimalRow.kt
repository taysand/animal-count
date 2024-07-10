package com.example.animalcount.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalcount.model.Animal
import com.example.animalcount.ui.theme.MediumPadding
import com.example.animalcount.util.SampleAnimalList

@Composable
fun AnimalRow(
    animal: Animal,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = MediumPadding,
            alignment = Alignment.CenterHorizontally
        ),
        modifier = modifier.fillMaxWidth(),
    ) {
        var count by remember { mutableIntStateOf(animal.count) }
        DecreaseCountButton { count-- }
        AnimalInfo(
            count = count,
            animal = animal,
            modifier = Modifier.weight(1f),
        )
        IncreaseCountButton { count++ }
    }
}

@Preview
@Composable
fun AnimalRowPreview() {
    AnimalRow(animal = SampleAnimalList[0])
}
