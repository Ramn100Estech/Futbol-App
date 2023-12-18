package com.example.myfootballapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myfootballapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //sharedpreferences
        val preferences = getSharedPreferences("myprefs", MODE_PRIVATE) ?: return

        val usuario = preferences.getString("usuario", "")
        binding.user.setText(usuario)

        binding.login.setOnClickListener {
            val user = binding.user.text.toString()
            val pass = binding.pass.text.toString()

            //No me deja añadir ni un toast ni un alert dialog dentro de el if
            if (user.isEmpty())
                binding.user.error = "Este campo no puede estar vacio"
            else if(pass.isEmpty())
                binding.pass.error = "Este campo no puede estar vacio"
            else if (user != "aficionado" && user != "jugador" && user != "directivo")
                binding.user.error = "Este usuario no existe"
            else if ((user == "aficionado" && pass != "123456") || (user == "jugador" && pass != "qwerasdf") || (user == "directivo" && pass != "asdfasdf"))
                binding.pass.error = "Contraseña incorrecta"
            else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("user", user)
                val usuario = preferences.edit()
                usuario.putString("usuario", user)
                usuario.apply()
                startActivity(intent)
            }
        }

        //login invitado
        binding.guest.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user", "")
            startActivity(intent)
            val usuario = preferences.edit()
            usuario.putString("usuario", "")
            usuario.apply()
        }
    }

    //Este es alert dialog que debia de salir si te equivocas en el login, pero no puedo usarlo en el if
    private fun errorlogin() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Mensaje del sistema")
        builder.setMessage("")
        builder.setNegativeButton("Cancelar", null)
        val dialog = builder.create() //AlertDialog
        dialog.show()
    }
}