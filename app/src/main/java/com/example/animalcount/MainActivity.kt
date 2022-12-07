package com.example.animalcount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.animalcount.navigation.pages.AnimalListPage
import com.example.animalcount.ui.theme.AnimalCountTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalCountTheme {
                AnimalListPage()
            }
        }
    }
}
