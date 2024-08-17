package com.example.animalcount.nav

import androidx.annotation.StringRes
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.animalcount.R

sealed interface AnimalCountDestination {
    @get:StringRes
    val title: Int
    val route: String
}

data object Home : AnimalCountDestination {
    @StringRes override val title: Int = R.string.app_name
    override val route: String = "home"
}

data object AddAnimal : AnimalCountDestination {
    @StringRes override val title: Int = R.string.add_animal
    override val route: String = "add_animal"
}

data object AnimalDetail : AnimalCountDestination {
    @StringRes override val title: Int = R.string.animal_detail
    override val route = "animal_detail"
    const val ANIMAL_ID_ARG = "animal_id"
    val routeWithArgs = "$route/{$ANIMAL_ID_ARG}"
    val arguments = listOf(
        navArgument(ANIMAL_ID_ARG) { type = NavType.StringType }
    )
}
