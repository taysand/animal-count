package com.example.animalcount.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AnimalCountScaffold(
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    floatingActionButton: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            AnimalCountTopAppBar(
                title = title,
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp,
            )
        },
        floatingActionButton = {
            if (floatingActionButton != null) {
                floatingActionButton()
            }
        },
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) { content() }
    }
}

@Preview
@Composable
fun AnimalCountScaffoldPreview() {
    AnimalCountScaffold(
        title = "Title",
        canNavigateBack = true,
        navigateUp = { },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "",
                )
            }
        }
    ) { }
}
