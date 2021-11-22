package com.sabirm.androidfb001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lugares.*

class Lugares : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugares)
        mostrarSaludo()
        regresar()
    }
    fun regresar(){
        buttonregresar.setOnClickListener(){
            val regresar= Intent(this,MainActivity::class.java)
            startActivity(regresar)
        }
    }
    fun mostrarSaludo(){
        val objetoNombre:Intent=intent
        var nombre=objetoNombre.getStringExtra("Nombre")
        textView2.setText("Bienvenido : "+nombre)
    }
}