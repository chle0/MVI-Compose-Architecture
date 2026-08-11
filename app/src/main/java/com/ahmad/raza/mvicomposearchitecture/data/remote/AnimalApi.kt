package com.ahmad.raza.mvicomposearchitecture.data.remote

import com.ahmad.raza.mvicomposearchitecture.model.Animal
import retrofit2.http.GET

interface AnimalApi {

    @GET("animals.json")
    suspend fun getAnimals(): List<Animal>
}