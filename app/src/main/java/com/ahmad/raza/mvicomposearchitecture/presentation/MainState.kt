package com.ahmad.raza.mvicomposearchitecture.presentation

import com.ahmad.raza.mvicomposearchitecture.model.Animal

sealed class MainState {

    object Idle : MainState()

    object Loading : MainState()

    data class Animals(val animals: List<Animal>) : MainState()

    data class Error(val error: String?) : MainState()
}