package com.example.animalcount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.animalcount.ui.pages.home.HomePage
import com.example.animalcount.ui.components.AppScaffold
import com.example.animalcount.ui.theme.AnimalCountTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalCountTheme {
                AppScaffold {
                    HomePage()
                }
            }
        }
    }
}
