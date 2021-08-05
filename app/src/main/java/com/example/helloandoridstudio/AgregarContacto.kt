package com.example.helloandoridstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_agregar_contacto.*

class AgregarContacto : AppCompatActivity() {

    val contactoAdmin = AdminContacto()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_contacto)
        guardarContacto_click()
    }

    fun guardarContacto_click(){
        btnGuardar.setOnClickListener(){
            val contacto = Contacto(0,txNombre.text.toString(),txNuemero.text.toString())
            contactoAdmin.addContacto(contacto)
            finish()
        }
    }
}