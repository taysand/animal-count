package com.example.animalcount

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animalcount.nav.AddAnimal
import com.example.animalcount.nav.Home
import com.example.animalcount.ui.pages.add.AddAnimalPage
import com.example.animalcount.ui.pages.home.HomePage
import com.example.animalcount.ui.theme.AnimalCountTheme

@Composable
fun AnimalCountApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    AnimalCountTheme {
        NavHost(
            navController = navController,
            startDestination = Home().route,
            modifier = modifier,
        ) {
            composable(route = Home().route) {
                HomePage(
                    navigateToAddAnimal = {
                        navController.navigate(route = AddAnimal().route)
                    }
                )
            }
            composable(route = AddAnimal().route) {
                AddAnimalPage()
            }
        }
    }
}
