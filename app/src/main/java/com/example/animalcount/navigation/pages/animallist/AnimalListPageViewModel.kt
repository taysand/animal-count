package com.example.animalcount.navigation.pages.animallist

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
class AnimalListPageViewModel @Inject constructor(
    private val repository: AnimalRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AnimalListPageState())
    val uiState: StateFlow<AnimalListPageState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.observeAll().collect { animalList ->
                _uiState.update { currentState ->
                    currentState.copy(animalList = animalList)
                }
            }
        }
    }

}

data class AnimalListPageState(
    val animalList: List<Animal> = emptyList(),
)
