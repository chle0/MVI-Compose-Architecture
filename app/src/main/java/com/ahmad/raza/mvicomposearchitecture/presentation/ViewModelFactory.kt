package com.ahmad.raza.mvicomposearchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahmad.raza.mvicomposearchitecture.data.remote.AnimalApi
import com.ahmad.raza.mvicomposearchitecture.data.repository.AnimalRepository

class ViewModelFactory(
    private val api: AnimalApi
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                AnimalRepository(api)
            ) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class: ${modelClass.name}"
        )
    }
}