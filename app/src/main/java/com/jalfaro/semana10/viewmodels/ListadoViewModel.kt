package com.jalfaro.semana10.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jalfaro.semana10.models.Personaje
import com.jalfaro.semana10.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await

class ListadoViewModel: ViewModel() {
    private val _personajes =  MutableLiveData<ArrayList<Personaje>>(arrayListOf())
    val personajes : LiveData<ArrayList<Personaje>> = _personajes

    fun getPersonajes() {
        /*
        _personajes.value = arrayListOf(
            Personaje(id=1, name = "Rick Sanchez", species = "Human", gender = "Male", image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            Personaje(id= 2, name = "Morty Smith", species = "Human", gender = "Male", image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg")
        )
         */
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.personajeService.getCharacters().await()
                _personajes.postValue(ArrayList(response.results))
                Log.d("Message", "tamano ${response.results.size}")
            } catch (e: Exception) {
                _personajes.postValue(arrayListOf())
                Log.d("Message", "${e.message}")
            }
        }
    }
}