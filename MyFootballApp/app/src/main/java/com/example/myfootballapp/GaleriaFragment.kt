package com.example.myfootballapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myfootballapp.databinding.FragmentGaleriaBinding


class GaleriaFragment : Fragment() {

    private lateinit var binding: FragmentGaleriaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGaleriaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sglm = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
        binding.recycler.layoutManager = sglm

        val listado = ArrayList<Galeria>()
        listado.add(Galeria(R.drawable.galeria_10))
        listado.add(Galeria(R.drawable.galeria_12))
        listado.add(Galeria(R.drawable.galeria_11))
        listado.add(Galeria(R.drawable.galeria_13))
        listado.add(Galeria(R.drawable.galeria_14))
        listado.add(Galeria(R.drawable.galeria_15))
        listado.add(Galeria(R.drawable.galeria_18))
        listado.add(Galeria(R.drawable.galeria_2))
        listado.add(Galeria(R.drawable.galeria_3))
        listado.add(Galeria(R.drawable.galeria_4))
        listado.add(Galeria(R.drawable.galeria_5))
        listado.add(Galeria(R.drawable.galeria_6))
        listado.add(Galeria(R.drawable.galeria_7))
        listado.add(Galeria(R.drawable.galeria_8))
        listado.add(Galeria(R.drawable.galeria_9))
        listado.add(Galeria(R.drawable.galeria_16))
        listado.add(Galeria(R.drawable.galeria_17))

        val adapter = GaleriaAdapter()
        binding.recycler.adapter = adapter

        adapter.addLista(listado)
    }
}