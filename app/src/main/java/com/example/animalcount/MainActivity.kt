package com.example.animalcount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.animalcount.navigation.pages.AnimalListPage
import com.example.animalcount.ui.components.AnimalCountScaffold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalCountScaffold {
                AnimalListPage()
            }
        }
    }
}
