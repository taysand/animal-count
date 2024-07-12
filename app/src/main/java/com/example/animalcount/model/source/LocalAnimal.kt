package com.example.animalcount.model.source

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.animalcount.model.Animal

@Entity(
    tableName = ANIMAL_TABLE
)
data class LocalAnimal(
    @PrimaryKey val id: String,
    val name: String,
    val count: Int,
)

fun LocalAnimal.toExternal() = Animal(
    name = name,
    count = count,
    id = id,
)

fun List<LocalAnimal>.toExternal() = map(LocalAnimal::toExternal)

fun Animal.toLocal() = LocalAnimal(
    id = id,
    name = name,
    count = count,
)
