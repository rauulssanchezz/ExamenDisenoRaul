package com.example.examendiseoraul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var añadir=findViewById<Button>(R.id.añadir)
        var ver = findViewById<Button>(R.id.ver)
        var newintent:Intent
        var nombre=intent.getStringExtra("nombre")
        var entrenador=intent.getStringExtra("entrenador")
        var tipo=intent.getStringExtra("tipo")
        var estatura=intent.getStringExtra("estatura")
        var comentarios=intent.getStringExtra("comentarios")
        var fecha=intent.getStringExtra("fecha")



        añadir.setOnClickListener {
            newintent=Intent(this,Anadir::class.java)
            startActivity(newintent)
        }

        ver.setOnClickListener {
            newintent=Intent(this,Ver::class.java)
            newintent.putExtra("nombre",nombre)
            newintent.putExtra("entrenador",entrenador)
            newintent.putExtra("tipo",tipo)
            newintent.putExtra("estatura",estatura)
            newintent.putExtra("comentarios",comentarios)
            newintent.putExtra("fecha",fecha)
            startActivity(newintent)
        }

    }
}