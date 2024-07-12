package com.example.animalcount.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalcount.R

@Composable
fun DeleteButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    CountButton(
        color = Color.Red,
        icon = R.drawable.baseline_remove_24,
        modifier = modifier,
        contentDescription = stringResource(id = R.string.delete_animal),
        enabled = enabled,
        onClick = onClick,
    )
}

@Preview
@Composable
fun DeleteButtonPreview() {
    DeleteButton { }
}
