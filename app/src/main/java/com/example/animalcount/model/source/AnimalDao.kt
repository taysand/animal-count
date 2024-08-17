package com.example.animalcount.model.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimalDao {
    @Query("SELECT * FROM animal")
    fun observeAll(): Flow<List<LocalAnimal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAnimal(animal: LocalAnimal)

    @Update
    suspend fun updateAnimal(animal: LocalAnimal)

    @Delete
    suspend fun deleteAnimal(animal: LocalAnimal)

    @Query("SELECT * FROM animal WHERE id=:id")
    suspend fun loadAnimal(id: String): LocalAnimal
}
