package com.example.myfootballapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfootballapp.databinding.FragmentEquipoBinding

class EquipoFragment : Fragment() {

    private lateinit var binding: FragmentEquipoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEquipoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.layoutManager = layoutManager

        val listado = ArrayList<Jugador>()
        listado.add(Jugador(1, "Clua", "David Clua Pumar", "Portero", "07/01/1995", "Vigo", 1.99, 85, "Burgos CF", "", R.drawable.a, 1, "escuelaestech"))
        listado.add(Jugador(2, "Lacroux", "Jany Lacroux", "Lateral derecho", "26/02/1996", "Bree (Bélgica)", 1.82, 79, "Genk Sub'19", "Lateral derecho que también se desenvuelve bien como central. Internacional en categorías inferiores con Bélgica", R.drawable.b, 2, ""))
        listado.add(Jugador(3, "Ginés", "Ánge Ginés Alcalá","Lateral izquierdo", "19/06/1994", "Peralada (Girona)", 1.73, 70, "Girona FC", "Ha disputado más de 100 partidos en segunda", R.drawable.i, 2, "escuelaestech"))
        listado.add(Jugador(4, "Guraya", "Raúl Guraya Gómez", "Defensa central", "14/05/1988", "Madrid", 1.83, 81, "Granada B", "Defensa central con gran experiencia en la categoría", R.drawable.c, 2, ""))
        listado.add(Jugador(5, "Monjonell", "Alba Monjonell Vila", "Defensa central", "06/06/1984", "Villar del Arzobispo (Valencia)", 1.85, 80, "Guadalajara", "Trayectoria: Valencia C - Valencia B - Barcelona B- - Gimnástic Tarragona - C.D. Guadalajara", R.drawable.d, 2, ""))
        listado.add(Jugador(6, "Mene", "Enzo Meneghello Peláez", "Mediapunta", "23/03/1989", "Santander", 1.84, 74, "Racing Santander B", "Centrocampista ofensivo con buena zurda", R.drawable.f, 3, "escuelaestech"))
        listado.add(Jugador(7, "Cimbrón", "Manuel Cimbrón Ortiz", "Mediocentro", "11/12/1984", "Albacete", 1.77, 74, "Valencia Mestalla", "Mediocentro de gran clase y muy técnico, que ayuda a sacar el balón jugado desde atrás", R.drawable.h, 3, ""))
        listado.add(Jugador(8, "Akeda", "Abdoulaye Akeda Opono", "Interior derecho", "04/07/1992", "Camerún", 1.75, 73, "Almería B", "Jugador muy rápido y de desborde. Suele irse de sus rivales por velocidad.", R.drawable.e, 3, ""))
        listado.add(Jugador(9,"Guillamas", "Sergio Guillamas Urquijo", "Interior izquierdo", "16/01/1992", "Vitoria-Gazteiz", 1.89, 73, "Mallorca B", "A pesar de su altura, posee gran velocidad y regate en carrera. Jugador muy habilidoso, también útil en el juego aéreo", R.drawable.j, 3, "escuelaestech"))
        listado.add(Jugador(10, "Pozo", "Víctor Pozo López", "Delantero", "14/11/1992", "Córdoba", 1.83, 78, "Córdoba CF", "Delantero con gran olfato de gol, la pasada temporada marcó 20 goles en la categoría de plata.", R.drawable.o, 4, ""))
        listado.add(Jugador(11, "Ari", "Arístides Martínez López", "Segundo delantero", "24/10/1985", "Granada", 1.76, 70, "CF Motril", "Delantero habilidoso y de gran técnica. Bueno en el último pase.", R.drawable.p, 4, ""))
        listado.add(Jugador(12, "José Sierra", "José Sierra Urquijo", "Entrenador", "24/19/1965", "Las Palmas (Gran Canaria)", 1.81, 85, "CD Mensajero", "- Como jugador: Málaga (88-92), Marbella (92-93), Mérida (93-94), Espanyol (94-97), Mérida (97-99), Las Palmas (99-05)\n - Como entrenador: 2º entrenador Algeciras (05-06), Mérida (06-07), Ojeador Numancia (07-08), Los Barrios (08-11), Vecindario (11-15)", R.drawable.player, 0, ""))

        val adapter = JugadorAdapter()
        binding.recyclerView.adapter = adapter

        adapter.addLista(listado)
    }
}