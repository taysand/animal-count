package com.example.animalcount.model.source

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalAnimal::class], version = 1, exportSchema = false)
abstract class AnimalDatabase : RoomDatabase() {
    abstract fun animalDao(): AnimalDao
}
