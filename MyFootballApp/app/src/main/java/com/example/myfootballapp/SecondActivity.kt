package com.example.myfootballapp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.MenuProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myfootballapp.databinding.CabeceraBinding
import com.example.myfootballapp.databinding.SecondActivityBinding
import java.text.SimpleDateFormat
import java.util.*


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = getIntent().extras
        val user = b!!.getString("user")

        val actionBar = supportActionBar

        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.exit -> {
                        val builder = android.app.AlertDialog.Builder(this@SecondActivity)
                        builder.setMessage("¿Deseas cerrar sesion?")
                        builder.setPositiveButton(
                            "Si"
                        ) { _, _ ->
                            val intent = Intent(this@SecondActivity,MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        builder.setNegativeButton("No", null)
                        val dialog = builder.create()
                        dialog.show()
                        return true
                    }
                    else -> return false
                }
            }
        })


        navController = findNavController(R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.equipoFragment, R.id.contactFragment
            ), binding.DrawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.Nav.setupWithNavController(navController)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.DrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.DrawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    if (!navController.navigateUp())
                        finish()
                }
            }
        })

//          val headerBinding = CabeceraBinding.inflate(layoutInflater)
//          binding.Nav.addHeaderView(headerBinding.root)
            val header = binding.Nav.getHeaderView(0)
            val textoUsuario = header.findViewById<TextView>(R.id.textView6)
            if (user.isNullOrEmpty()){
                textoUsuario.text = "Invitado"
            } else {
                textoUsuario.text = user
            }
            val textoFecha = header.findViewById<TextView>(R.id.textView8)
            textoFecha.text = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return  navController.navigateUp(appBarConfiguration) ||
                super.onSupportNavigateUp()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("¿Salir de la aplicacion?")
            builder.setPositiveButton("Si", DialogInterface.OnClickListener {
                    dialog, i ->
                finish()
            })
            builder.setNegativeButton("No", null)
            val dialog = builder.create() //AlertDialog
            dialog.show()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }


}