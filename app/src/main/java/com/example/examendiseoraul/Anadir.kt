package com.example.examendiseoraul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Anadir : AppCompatActivity() {
    lateinit var newintent:Intent
    var tipo=""
    var nombre=""
    var entrenador=""
    var estatura=0
    var comentarios=""
    var fecha=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir)
        var tipoEdit = findViewById<AutoCompleteTextView>(R.id.tipo)
        var nombreEdit = findViewById<TextInputEditText>(R.id.nombre)
        var entrenadorEdit = findViewById<TextInputEditText>(R.id.entrenador)
        var estaturaEdit = findViewById<TextInputEditText>(R.id.Estatura)
        var comentariosEdit = findViewById<TextInputEditText>(R.id.Comentarios)
        var fechaEdit = findViewById<TextInputEditText>(R.id.fechaatrapado)
        var layoutfecha = findViewById<TextInputLayout>(R.id.layoutfecha)
        var tipos = arrayOf(
            "Agua",
            "Fuego",
            "Planta",
            "Locomotora",
            "Leopard2AE",
            "Socialista",
            "Nazi",
            "Vagabundo",
            "Recoge Pelotas",
            "Facha"
        )
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tipos)
        val regex = "[aeiouAEIOU]".toRegex()


        tipoEdit.setAdapter(adapter)

        tipoEdit.doAfterTextChanged {
            if (!tipoEdit.text.isNullOrBlank()) {
                tipo = tipoEdit.text.toString()
            }
        }
            fechaEdit.setOnClickListener {
                var builder = MaterialDatePicker.Builder.datePicker()
                var picker = builder.build()

                picker.addOnPositiveButtonClickListener {
                    val selectedDate = picker.selection

                    val calendarActual = Calendar.getInstance()
                    val fechaActual = calendarActual.timeInMillis

                    if (selectedDate!! > fechaActual) {
                        fechaEdit.setError("La fecha no puede ser posterior al día actual")
                        layoutfecha.error = "La fecha no puede ser posterior al día actual"
                        Toast.makeText(
                            this,
                            "La fecha no puede ser posterior a la actual",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {

                    }
                    val calendarSeleccionada = Calendar.getInstance()
                    calendarSeleccionada.timeInMillis = selectedDate!!
                    val formato = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    fechaEdit.setText(formato.format(calendarSeleccionada.time))

                    fecha = fechaEdit.text.toString()
                }

                picker.show(supportFragmentManager, "fecha")

            }

            nombreEdit.doAfterTextChanged {
                if (!nombreEdit.text.isNullOrBlank()) {
                    if (nombreEdit.text!!.length < 3) {
                        nombreEdit.setError("El nombre debe contener al menos 3 caracteres")
                    } else {
                        nombre = nombreEdit.text.toString()
                    }
                }
            }

            entrenadorEdit.doAfterTextChanged {
                if (!entrenadorEdit.text.isNullOrBlank()) {
                    if (entrenadorEdit.text!!.length >= 25) {
                        entrenadorEdit.setError("No puede contener mas de 25 caracteres")
                    } else if (!entrenadorEdit.text!!.contains(regex)) {
                        entrenadorEdit.setError("Debe contener al menos una vocal")
                    } else {
                        entrenador = entrenadorEdit.text.toString()
                    }
                }
            }

            estaturaEdit.doAfterTextChanged {
                if (!estaturaEdit.text.isNullOrBlank()) {
                    if (!!estaturaEdit.text!!.isDigitsOnly() && estaturaEdit.text.toString()
                            .contains(".")
                    ) {
                        estaturaEdit.setError("La estatura debe ser en centimetros")
                    } else {
                        estatura = estaturaEdit.text.toString().toInt()
                    }
                }
            }

            comentariosEdit.doAfterTextChanged {
                if (!comentariosEdit.text.isNullOrBlank()) {
                    comentarios = comentariosEdit.text.toString()
                }

            }



    }

    fun back(view: View) {
        newintent=Intent(this,MainActivity::class.java)
        startActivity(newintent)
    }

    fun guardar(view: View) {
        newintent=Intent(this,MainActivity::class.java)
        newintent.putExtra("nombre",nombre)
        newintent.putExtra("entrenador",entrenador)
        newintent.putExtra("tipo",tipo)
        newintent.putExtra("estatura",estatura)
        newintent.putExtra("comentarios",comentarios)
        newintent.putExtra("fecha",fecha)

    }
}