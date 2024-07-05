package com.example.animalcount.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "animal"
)
data class LocalAnimal(
    @PrimaryKey val id: String,
    val name: String,
    val count: Int,
)
