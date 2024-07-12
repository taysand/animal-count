package com.example.animalcount.ui.pages.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalcount.model.Animal
import com.example.animalcount.model.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val repository: AnimalRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomePageUiState())
    val uiState: StateFlow<HomePageUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.observeAll().collect { animalList ->
                _uiState.update { currentState ->
                    currentState.copy(animalList = animalList)
                }
            }
        }
    }

    fun addAnimal() {
        viewModelScope.launch {
            repository.create("Test animal")
        }
    }

    fun increaseCount(index: Int) {
        val animal = uiState.value.animalList[index]
        val updatedAnimal = animal.copy(count = animal.count + 1)
        viewModelScope.launch {
            repository.increaseCount(updatedAnimal)
        }
    }
}

data class HomePageUiState(
    val animalList: List<Animal> = emptyList(),
)
