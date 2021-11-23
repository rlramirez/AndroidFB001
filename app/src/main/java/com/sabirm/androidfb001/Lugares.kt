package com.sabirm.androidfb001

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_lugares.*
import java.time.Clock
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class Lugares : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugares)
        mostrarSaludo()
        hora()
        regresar()
    }
    fun regresar(){
        buttonregresar.setOnClickListener(){
            val regresar= Intent(this,MainActivity::class.java)
            startActivity(regresar)
        }
    }
    fun mostrarSaludo(){
        val objetoIntent:Intent=intent
        var Nombre=objetoIntent.getStringExtra("Nombre")

        textView2.text=("Bienvenido : $Nombre")
        textView2.setText("Bienvenido : $Nombre")
    }
    //@RequiresApi(Build.VERSION_CODES.O)
    fun hora(){
        //val horaActual = Instant.now()
        val c: Calendar = Calendar.getInstance()
        val dia:Int=c.get(Calendar.DAY_OF_WEEK)
        val mes:Int=c.get(Calendar.MONTH)
        val year:Int=c.get(Calendar.YEAR)
        val hora:Int=c.get(Calendar.HOUR)
        val minutos:Int=c.get(Calendar.MINUTE)
        tv_hora.setText("La hora actual es $year-$mes-$dia | $hora:$minutos ")
    }

}