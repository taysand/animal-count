package com.example.animalcount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.animalcount.navigation.pages.animallist.AnimalListPage
import com.example.animalcount.ui.components.AnimalCountScaffold
import com.example.animalcount.ui.theme.AnimalCountTheme
import com.example.animalcount.util.SampleAnimalList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalCountTheme {
                AnimalCountScaffold {
                    AnimalListPage(SampleAnimalList)
                }
            }
        }
    }
}
