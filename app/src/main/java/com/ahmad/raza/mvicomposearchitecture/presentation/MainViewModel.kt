package com.ahmad.raza.mvicomposearchitecture.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmad.raza.mvicomposearchitecture.data.repository.AnimalRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repo: AnimalRepository) : ViewModel() {

    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)
    var state = mutableStateOf<MainState>(MainState.Idle)
        private set

    init {
        handleIntent()
    }

    fun onIntent(intent: MainIntent) {
        viewModelScope.launch {
            userIntent.send(intent)
        }
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect { intent ->

                when (intent) {
                    is MainIntent.FetchAnimals -> {
                        fetchAnimals()
                    }
                }
            }
        }
    }

    private suspend fun fetchAnimals() {
        viewModelScope.launch {
            state.value = MainState.Loading
            state.value = try {
                MainState.Animals(repo.getAnimals())
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }
}