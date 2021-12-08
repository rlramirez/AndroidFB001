package com.sabirm.androidfb001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_home.*

enum class ProviderType{
    BASIC,
    GOOGLE,
    FACEBOOK
}
class HomeActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bundle:Bundle?=intent.extras
        val email:String? = bundle?.getString("email")
        val provider:String? = bundle?.getString("provider")


        setup(email?:"", provider?:"")
    }
    private fun setup(email:String, provider:String){
        title ="Inicio"
        tv_correo.text=email
        tv_provider.text=provider

        btn_salir.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
        btn_guardar.setOnClickListener(){
            db.collection("users").document(email).set(
                hashMapOf("provider" to provider, "address" to et_direccion.text.toString(),
                "phone" to et_telefono.text.toString(), "rol" to et_rol.text.toString())
            )
        }
        btn_recuperar.setOnClickListener(){
            db.collection("users").document(email).get().addOnSuccessListener {
                et_direccion.setText(it.get("address") as String?)
                et_telefono.setText(it.get("phone") as String?)
                et_rol.setText(it.get("rol") as String?)
            }
        }
        btn_borrar.setOnClickListener(){
            db.collection("users").document(email).delete()
        }
    }
}