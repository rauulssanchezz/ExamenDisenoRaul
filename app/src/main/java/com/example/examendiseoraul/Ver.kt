package com.example.examendiseoraul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Ver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver)
        var nombre=intent.getStringExtra("nombre")
        var entrenador=intent.getStringExtra("entrenador")
        var tipo=intent.getStringExtra("tipo")
        var estatura=intent.getStringExtra("estatura")
        var comentarios=intent.getStringExtra("comentarios")
        var fecha=intent.getStringExtra("fecha")
        var listado=findViewById<TextView>(R.id.listado)

        listado.setText("$nombre\t$tipo\n$estatura\t$fecha\n")


    }
}