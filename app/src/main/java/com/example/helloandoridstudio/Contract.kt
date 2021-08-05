package com.example.helloandoridstudio

import android.provider.BaseColumns
import java.net.IDN

class Contract {
    //Definimos los Campos de la tabla
    class Contacto:BaseColumns{
        companion object{
            val ID ="id"
            val NOMBRE = "nombre"
            val NUMERO = "numero"
        }
    }

}