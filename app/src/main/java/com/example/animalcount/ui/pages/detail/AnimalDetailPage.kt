package com.example.animalcount.ui.pages.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AnimalDetailPage(
    id: String,
    modifier: Modifier = Modifier,
) {
    Text("animal detail page for $id")
}
