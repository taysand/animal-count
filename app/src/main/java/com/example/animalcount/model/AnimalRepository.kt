package com.example.animalcount.model

import com.example.animalcount.di.DefaultDispatcher
import com.example.animalcount.model.source.AnimalDao
import com.example.animalcount.model.source.toExternal
import com.example.animalcount.model.source.toLocal
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject

class AnimalRepository @Inject constructor(
    private val localDataSource: AnimalDao,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
) {
    fun observeAll(): Flow<List<Animal>> = localDataSource.observeAll().map { animals ->
        animals.toExternal()
    }

    suspend fun create(name: String, emoji: String): String {
        val animalId = withContext(dispatcher) {
            createAnimalId()
        }
        val animal = Animal(
            id = animalId,
            name = name,
            count = 0,
            emoji = emoji,
        )
        localDataSource.addAnimal(animal.toLocal())
        return animalId
    }

    suspend fun increaseCount(animal: Animal) {
        localDataSource.updateAnimal(animal.toLocal())
    }

    suspend fun deleteAnimal(animal: Animal) {
        localDataSource.deleteAnimal(animal.toLocal())
    }

    private fun createAnimalId(): String {
        return UUID.randomUUID().toString()
    }
}
