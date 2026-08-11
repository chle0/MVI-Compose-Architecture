package com.ahmad.raza.mvicomposearchitecture.data.repository

import com.ahmad.raza.mvicomposearchitecture.data.remote.AnimalApi

class AnimalRepository(
    private val api: AnimalApi
) {
    suspend fun getAnimals() = api.getAnimals()
}