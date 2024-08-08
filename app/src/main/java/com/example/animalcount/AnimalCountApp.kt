package com.example.animalcount

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.animalcount.nav.AddAnimal
import com.example.animalcount.nav.AnimalCountNavHost
import com.example.animalcount.nav.Home
import com.example.animalcount.ui.components.AnimalCountScaffold
import com.example.animalcount.ui.theme.AnimalCountTheme

@Composable
fun AnimalCountApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    AnimalCountTheme {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentScreen =
            when (backStackEntry?.destination?.route) {
                AddAnimal.route -> AddAnimal
                Home.route -> Home
                else -> Home
            }

        AnimalCountScaffold(
            floatingActionButton = {
                if (currentScreen == Home) {
                    FloatingActionButton(
                        onClick = {
                            navController.navigate(route = AddAnimal.route)
                        },
                    ) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = stringResource(R.string.add_animal),
                        )
                    }
                }
            },
            modifier = modifier,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() },
            title = stringResource(id = currentScreen.title),
        ) {
            AnimalCountNavHost(
                navController = navController,
            )
        }
    }
}
