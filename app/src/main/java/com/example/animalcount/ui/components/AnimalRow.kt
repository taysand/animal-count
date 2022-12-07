package com.example.animalcount.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.animalcount.R
import com.example.animalcount.model.Animal

@Composable
fun AnimalRow(
    animal: Animal,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = 10.dp,
            alignment = Alignment.CenterHorizontally
        ),
        modifier = modifier.fillMaxWidth(),
    ) {
        var count by remember { mutableStateOf(animal.count) }
        AnimalCountButton(
            color = Color.Red,
            icon = R.drawable.baseline_remove_24,
            contentDescription = stringResource(id = R.string.remove_one),
        ) { count-- }
        AnimalInfo(
            count = count,
            animal = animal,
            modifier = Modifier.weight(1f),
        )
        AnimalCountButton(
            color = Color.Green,
            icon = R.drawable.baseline_add_24,
            contentDescription = stringResource(id = R.string.add_one),
        ) { count++ }
    }
}
