package com.example.animalcount.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.animalcount.ui.theme.AnimalCountTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalCountScaffold(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    AnimalCountTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                ) {
                    Text(
                        text = "Animal Count",
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
            }
        ) { contentPadding ->
            Box(modifier = Modifier.padding(contentPadding)) { content() }
        }
    }
}