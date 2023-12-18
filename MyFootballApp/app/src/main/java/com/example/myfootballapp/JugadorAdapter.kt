package com.example.myfootballapp

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myfootballapp.databinding.HolderEquipoBinding

class JugadorAdapter : Adapter<JugadorAdapter.CeldaJugador>(){

    val listado = ArrayList<Jugador>()
    inner class CeldaJugador(val binding: HolderEquipoBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaJugador {
        val inflater = LayoutInflater.from(parent.context)
        return CeldaJugador(HolderEquipoBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    override fun onBindViewHolder(holder: CeldaJugador, position: Int) {
        val jugador = listado[position]
        with(holder.binding) {
            textView4.text = jugador.apellido
            textView5.text = jugador.posicion
            imageView5.setImageResource(jugador.img)
        }
    }

    fun addLista(list: ArrayList<Jugador>){
        listado.addAll(list)
        notifyItemRangeInserted(0,listado.size)
    }
}

