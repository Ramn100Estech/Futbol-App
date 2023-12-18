package com.example.myfootballapp

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.myfootballapp.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:37.999253180861196, -3.4734243638792231?q=Baepapel")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        binding.button2.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:info@escuelaestech.es, secretaria@escuelaestech.es")
            startActivity(intent);
        }

        binding.button3.setOnClickListener {
            val num = "+34953636000"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", num, null))
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone="+ +34697246008)
            startActivity(intent)
        }

        // ^                           |
        // | BOTONES        FORMULARIO |
        // |                           !

        val arrayOpciones = arrayOf(
            "Otro",
            "Abonado",
            "Aficionado",
            "Simpatizante",
            "Socio"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, arrayOpciones)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        binding.send.setOnClickListener {
            val name = binding.name.text.toString()
            val mail = binding.mail.text.toString()
            val phone = binding.phone.text.toString()
            val message = binding.message.text.toString()
            var tipo = ""

            val sel = binding.spinner.selectedItemPosition
            if (sel == 0) tipo = "Socio"
            if (sel == 1) tipo = "Abonado"
            if (sel == 2) tipo = "Aficionado"
            if (sel == 3) tipo = "Simpatizante"
            if (sel == 4) tipo = "Otro"

            val addresses = arrayOf("mailto:info@escuelaestech.es",
                "secretaria@escuelaestech.es")

            if (name.isEmpty())
                binding.name.error = "Escribe un nombre"
            else if (mail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches())
                binding.mail.error = "Escribe un email"
            else if (phone.isEmpty())
                binding.phone.error = "Escribe un numero"
            else if (message.isEmpty())
                binding.message.error = "Escribe un mensaje"
            else if (!binding.checkBox.isChecked)
                binding.checkBox.error = "Marque la casilla"
            else {
                val builder = AlertDialog.Builder(requireContext())
                builder.setMessage("¿Desea enviar el formulario?")
                builder.setPositiveButton("Si", DialogInterface.OnClickListener {
                        dialog, i ->
                    val text = "Nombre: $name                 " +
                            "Telefono: $phone            " +
                            "Correo $mail             " +
                            "Mensaje $message                " +
                            "Tipo Usuario $tipo"
                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:")
                    intent.putExtra(Intent.EXTRA_EMAIL, addresses)
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Formulario de contacto")
                    intent.putExtra(Intent.EXTRA_TEXT, text)
                    startActivity(intent);
                })
                builder.setNegativeButton("No", null)
                val dialog = builder.create() //AlertDialog
                dialog.show()
            }
        }

    }
}
