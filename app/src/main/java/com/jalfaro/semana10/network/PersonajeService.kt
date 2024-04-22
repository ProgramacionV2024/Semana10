package com.jalfaro.semana10.network

import com.jalfaro.semana10.models.PersonajeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface PersonajeService {
    @GET("character")
    fun getCharacters(): Call<PersonajeResponse>
}