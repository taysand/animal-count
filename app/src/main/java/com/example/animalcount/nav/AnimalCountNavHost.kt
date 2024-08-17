package com.example.animalcount.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.animalcount.ui.pages.add.AddAnimalPage
import com.example.animalcount.ui.pages.detail.AnimalDetailPage
import com.example.animalcount.ui.pages.home.HomePage

@Composable
fun AnimalCountNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier,
    ) {
        composable(route = Home.route) {
            HomePage(
                openDetailPage = { animalId ->
                    navController.navigate(route = "${AnimalDetail.route}/$animalId")
                }
            )
        }
        composable(route = AddAnimal.route) {
            AddAnimalPage(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = AnimalDetail.routeWithArgs,
            arguments = AnimalDetail.arguments,
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString(AnimalDetail.ANIMAL_ID_ARG)?.let {
                AnimalDetailPage(id = it)
            }
        }
    }
}
