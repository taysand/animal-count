package com.example.animalcount.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnimalInfoCard(
    animal: Animal,
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .combinedClickable(
                    onClick = { onClick() },
                    onClickLabel = stringResource(id = R.string.add_one),
                    onLongClick = { onLongClick() },
                    onLongClickLabel = stringResource(R.string.open_animal_detail_page)
                )
                .fillMaxSize()
                .padding(horizontal = LargePadding, vertical = MediumPadding),
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
        onLongClick = { },
    )
}
