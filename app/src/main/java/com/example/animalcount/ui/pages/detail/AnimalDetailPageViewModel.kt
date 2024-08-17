package com.example.animalcount.ui.pages.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalcount.model.Animal
import com.example.animalcount.model.AnimalRepository
import com.example.animalcount.nav.AnimalDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalDetailPageViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: AnimalRepository,
) : ViewModel() {
    private val animalId: String? = savedStateHandle[AnimalDetail.ANIMAL_ID_ARG]
    private val _uiState = MutableStateFlow(DetailPageUiState())
    val uiState: StateFlow<DetailPageUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            animalId?.let {
                val animal = repository.loadAnimal(animalId)
                _uiState.update { currentState ->
                    currentState.copy(animal = animal)
                }
            }
        }
    }

    fun deleteAnimal() {
        viewModelScope.launch {
            uiState.value.animal?.let {
                repository.deleteAnimal(it)
            }
        }
    }
}

data class DetailPageUiState(
    val animal: Animal? = null
)
