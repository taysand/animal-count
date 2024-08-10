package com.example.animalcount.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalcount.R
import com.example.animalcount.model.Animal
import com.example.animalcount.ui.theme.LargeFont
import com.example.animalcount.ui.theme.LargePadding
import com.example.animalcount.ui.theme.MediumPadding
import com.example.animalcount.util.SampleAnimalList

@Composable
fun AnimalInfoCard(
    animal: Animal,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .clickable(
                onClickLabel = stringResource(id = R.string.add_one),
            ) { onClick() },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = LargePadding, vertical = MediumPadding),
        ) {
            Text(
                text = animal.count.toString(),
                style = MaterialTheme.typography.titleLarge.copy(fontSize = LargeFont),
            )
            Text(
                text = animal.emoji,
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                text = animal.name,
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}

@Preview
@Composable
fun AnimalInfoCardPreview() {
    AnimalInfoCard(
        animal = SampleAnimalList[0],
        onClick = { },
    )
}
