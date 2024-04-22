package com.jalfaro.semana10.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jalfaro.semana10.R
import com.jalfaro.semana10.databinding.PersonajeRowLayoutBinding
import com.jalfaro.semana10.models.Personaje
import java.net.URL

class PersonajeAdapter(val list: ArrayList<Personaje>): RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder>() {
    class PersonajeViewHolder(val binding: PersonajeRowLayoutBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder =
        PersonajeViewHolder(PersonajeRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        holder.binding.image.setImageResource(R.drawable.ic_launcher_background)
        holder.binding.txtNombre.text = list[position].name
        holder.binding.txtEspecie.text = list[position].species
        holder.binding.txtGenero.text = list[position].gender
    }
    fun showNewData(newList :ArrayList<Personaje> ) {
        list.clear()
        list.addAll(newList)
    }
}