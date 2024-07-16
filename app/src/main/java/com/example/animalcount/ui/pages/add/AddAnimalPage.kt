package com.example.animalcount.ui.pages.add

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddAnimalPage(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text("add animal page")
    }
}


@Preview
@Composable
fun AddAnimalPagePreview() {
    AddAnimalPage()
}
