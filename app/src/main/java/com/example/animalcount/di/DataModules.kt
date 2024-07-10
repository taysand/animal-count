package com.example.animalcount.di

import android.content.Context
import androidx.room.Room
import com.example.animalcount.model.AnimalDao
import com.example.animalcount.model.AnimalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideAnimalDatabase(@ApplicationContext context: Context): AnimalDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AnimalDatabase::class.java,
            "Animals.db"
        ).build()
    }

    @Provides
    fun provideAnimalDao(database: AnimalDatabase) : AnimalDao = database.animalDao()
}
