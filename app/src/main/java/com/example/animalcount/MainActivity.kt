package com.example.animalcount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.animalcount.model.Animal
import com.example.animalcount.ui.theme.AnimalCountTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalCountTheme {
                AnimalList()
            }
        }
    }
}

@Composable
fun AnimalList() {
    val animalList = listOf(
        Animal(name = "Cat"),
        Animal(name = "Cow"),
        Animal(name = "Crab"),
        Animal(name = "Dog"),
        Animal(name = "Seal"),
        Animal(name = "Sea Lion"),
    )

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        for (animal in animalList) {
            AnimalRow(animal)
        }
    }
}

@Composable
fun AnimalRow(animal: Animal) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var count by remember { mutableStateOf(animal.count) }
        IconButton(
            onClick = { count-- }
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_remove_24),
                contentDescription = "Remove one"
            )
        }
        Text("${animal.name}: $count")
        IconButton(
            onClick = { count++ }
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Add one"
            )
        }
    }
}