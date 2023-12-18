package com.example.myfootballapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.example.myfootballapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Llamo a SharedPreferences
        val preferences = requireActivity().getSharedPreferences("myprefs", Context.MODE_PRIVATE)

        var a = preferences.getInt("contador", 0)

        val usuario = preferences.getString("usuario", "")
        if (usuario.isNullOrEmpty())
            binding.textView.setText("")
        else
        binding.textView.setText("BIENVENIDO       $usuario")

        binding.BETIS.setOnClickListener{

            a++
            val contador = preferences.edit()
            contador.putInt("contador", a)
            contador.apply()
            val b = preferences.getInt("contador", 0)
            if (b == 10) {
                val builder = AlertDialog.Builder(requireContext())
                builder.setMessage("¿Quieres reclamar tu premio?")
                builder.setPositiveButton("Si", DialogInterface.OnClickListener { dialog, i ->
                    val array = resources.getStringArray(R.array.lista_colores)

                    val builder = AlertDialog.Builder(requireContext())
                    builder.setItems(R.array.lista_colores) { dialog, position ->
                        val builder = AlertDialog.Builder(requireContext())
                        builder.setMessage("Tu codigo es 5H8TK")
                        builder.setPositiveButton("Ok", DialogInterface.OnClickListener {
                                dialog, i ->
                        })
                        val dialog = builder.create() //AlertDialog
                        dialog.show()
                    }
                    builder.create().show()
                })
                builder.setNegativeButton("No", null)
                val dialog = builder.create() //AlertDialog
                dialog.show()
            }
        }
    }
}