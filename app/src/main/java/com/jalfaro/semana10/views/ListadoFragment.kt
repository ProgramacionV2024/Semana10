package com.jalfaro.semana10.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jalfaro.semana10.R
import com.jalfaro.semana10.adapter.PersonajeAdapter
import com.jalfaro.semana10.databinding.FragmentListadoBinding
import com.jalfaro.semana10.viewmodels.ListadoViewModel


class ListadoFragment : Fragment() {
    lateinit var binding: FragmentListadoBinding
    lateinit var viewModel : ListadoViewModel
    lateinit var adapter: PersonajeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ListadoViewModel::class.java)
        viewModel.personajes.observe(viewLifecycleOwner) {
            adapter.showNewData(it)
        }
        adapter = PersonajeAdapter(arrayListOf())
        binding.rvListado.adapter = adapter
        binding.rvListado.layoutManager = LinearLayoutManager(binding.root.context)
        viewModel.getPersonajes()
        return binding.root
    }

}