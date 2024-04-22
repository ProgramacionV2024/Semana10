package com.jalfaro.semana10.models

data class Personaje(
    val id: Int,
    val name: String,
    val species: String,
    val gender: String,
    val image: String
)

data class PersonajeInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?,
)

data class PersonajeResponse(
    val info: PersonajeInfo,
    val results: List<Personaje>
)