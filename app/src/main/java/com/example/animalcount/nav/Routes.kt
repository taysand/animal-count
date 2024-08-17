package com.example.animalcount.nav

import androidx.annotation.StringRes
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
    override val title: Int = R.string.open_animal_detail_page
    override val route: String = "animal_detail"
}
