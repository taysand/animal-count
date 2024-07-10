package com.example.animalcount.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalcount.R
import com.example.animalcount.ui.theme.HugePadding

@Composable
fun CountButton(
    color: Color,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    contentDescription: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .size(HugePadding)
            .background(color)
            .clickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painterResource(id = icon),
            contentDescription = contentDescription,
        )
    }
}

@Composable
fun DecreaseCountButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    CountButton(
        color = Color.Red,
        icon = R.drawable.baseline_remove_24,
        modifier = modifier,
        contentDescription = stringResource(id = R.string.remove_one),
        enabled = enabled,
        onClick = onClick,
    )
}

@Composable
fun IncreaseCountButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    CountButton(
        color = Color.Green,
        icon = R.drawable.baseline_add_24,
        modifier = modifier,
        contentDescription = stringResource(id = R.string.add_one),
        enabled = enabled,
        onClick = onClick,
    )
}

@Preview
@Composable
fun DecreaseCountButtonPreview() {
    DecreaseCountButton { }
}

@Preview
@Composable
fun IncreaseCountButtonPreview() {
    IncreaseCountButton { }
}
