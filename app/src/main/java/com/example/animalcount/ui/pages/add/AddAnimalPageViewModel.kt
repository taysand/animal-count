package com.example.animalcount.ui.pages.add

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalcount.model.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddAnimalPageViewModel @Inject constructor(
    private val repository: AnimalRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AddAnimalPageUiState())
    val uiState: StateFlow<AddAnimalPageUiState> = _uiState.asStateFlow()

    fun addAnimal() {
        viewModelScope.launch {
            repository.create(
                name = uiState.value.name.capitalize(Locale.current),
                emoji = uiState.value.emoji,
            )
        }
    }

    fun updateAnimalName(name: String) {
        _uiState.update { currentState ->
            currentState.copy(name = name)
        }
    }
}

data class AddAnimalPageUiState(
    val name: String = "",
    val emoji: String = "",
)
