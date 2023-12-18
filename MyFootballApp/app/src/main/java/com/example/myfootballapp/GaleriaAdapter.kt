package com.example.myfootballapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myfootballapp.databinding.HolderGaleriaBinding

class GaleriaAdapter : Adapter<GaleriaAdapter.CeldaGaleria>(){

    val listado = ArrayList<Galeria>()
    inner class CeldaGaleria(val binding: HolderGaleriaBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaGaleria {
        val inflater = LayoutInflater.from(parent.context)
        return CeldaGaleria(HolderGaleriaBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    override fun onBindViewHolder(holder: CeldaGaleria, position: Int) {
        val galeria = listado[position]
        with(holder.binding) {
            imageView7.setImageResource(galeria.foto)
        }
    }

    fun addLista(list: ArrayList<Galeria>){
        listado.addAll(list)
        notifyItemRangeChanged(0, listado.size)
    }
}