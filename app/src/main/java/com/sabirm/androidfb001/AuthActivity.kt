package com.sabirm.androidfb001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //autentication
        setup()
    }
    private fun setup(){
        title = "Autentication"
        btn_registar.setOnClickListener{
            if (et_email.text.isNotEmpty() && et_clave.text.isNotEmpty()){

                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(et_email.text.toString(),
                        et_clave.text.toString()).addOnCompleteListener{
                            if (it.isSuccessful){
                                showHome(it.result?.user?.email?:"", ProviderType.BASIC)
                            }else{
                                showAlert()
                                //println(it.result)
                            }
                }
            }

        }
        btn_acceder.setOnClickListener(){
            if (et_email.text.isNotEmpty() && et_clave.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(et_email.text.toString(),
                    et_clave.text.toString()).addOnCompleteListener(){
                    if (it.isSuccessful){
                        showHome(it.result?.user?.email?:"", ProviderType.BASIC)
                    }else{
                        showAlert2()
                    }
                }
            }
        }
    }
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error de regsitro ")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog=builder.create()
        dialog.show()


    }
    private fun showAlert2(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error de autenticado ")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog=builder.create()
        dialog.show()


    }
    private fun showHome(email:String, provider: ProviderType){
        val homeIntent:Intent=Intent(this,HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
            startActivity(homeIntent)
    }
}