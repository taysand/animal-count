package com.example.animalcount.ui.pages.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalcount.model.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddAnimalPageViewModel @Inject constructor(
    private val repository: AnimalRepository,
) : ViewModel() {
    fun addAnimal(animal: String) {
        viewModelScope.launch {
            repository.create(animal)
        }
    }
}

