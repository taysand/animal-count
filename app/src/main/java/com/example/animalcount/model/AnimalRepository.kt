package com.example.animalcount.model

import com.example.animalcount.di.DefaultDispatcher
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

    suspend fun create(name: String): String {
        val animalId = withContext(dispatcher) {
            createAnimalId()
        }
        val animal = Animal(
            id = animalId,
            name = name,
            count = 0
        )
        localDataSource.upsert(animal.toLocal())
        return animalId
    }

    private fun createAnimalId(): String {
        return UUID.randomUUID().toString()
    }
}
