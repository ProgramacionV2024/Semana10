package com.jalfaro.semana10.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jalfaro.semana10.models.Personaje

class ListadoViewModel: ViewModel() {
    private val _personajes =  MutableLiveData<ArrayList<Personaje>>(arrayListOf())
    val personajes : LiveData<ArrayList<Personaje>> = _personajes

    fun getPersonajes() {
        _personajes.value = arrayListOf(
            Personaje(id=1, name = "Rick Sanchez", species = "Human", gender = "Male", image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            Personaje(id= 2, name = "Morty Smith", species = "Human", gender = "Male", image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg")
        )
    }
}