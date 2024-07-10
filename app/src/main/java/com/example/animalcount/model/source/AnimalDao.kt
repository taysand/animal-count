package com.example.animalcount.model.source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimalDao {
    @Query("SELECT * FROM animal")
    fun observeAll(): Flow<List<LocalAnimal>>

    @Upsert
    suspend fun upsert(animal: LocalAnimal)

    @Upsert
    suspend fun upsertAll(animals: List<LocalAnimal>)

    @Query("UPDATE animal SET count = :count WHERE id = :animalId")
    suspend fun updateCount(animalId: String, count: Int)

    @Query("DELETE FROM animal")
    suspend fun deleteAll()
}
