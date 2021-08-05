package com.example.helloandoridstudio

import android.database.DatabaseUtils
import android.widget.Toast


data class Contacto( var id:Int, var nombre:String, var numero:String)

class AdminContacto {
    //Query Regrese los nombres de los contactos
    fun getAllNames():ArrayList<String>?{
        try {
            //respuesta
            val nombres = arrayListOf<String>()
            val db = AppContactos.DB.readableDatabase
            //Checamos si hay datos
            val numDatos = DatabaseUtils.queryNumEntries(db,AppContactos.TB_CONTACTOS).toInt()
            if(numDatos > 0){
                val qry = "SELECT ${Contract.Contacto.NOMBRE} FROM ${AppContactos.TB_CONTACTOS}"
                val c = db.rawQuery(qry,null)
                //Nos Ponemos al Inicio
                c.moveToFirst()
                do{
                    //Rellenamos el arreglo de respuestas
                    nombres.add(c.getString(c.getColumnIndex(Contract.Contacto.NOMBRE)))
                }while (c.moveToNext())

            }else {
                Toast.makeText(AppContactos.CONTEXT,"No hay contactos guardados",Toast.LENGTH_SHORT).show()
            }
            db.close()
            return nombres
        }catch (ex:Exception){
            Toast.makeText(AppContactos.CONTEXT,"No se pudo recuperar la lista",Toast.LENGTH_SHORT).show()
            return null
        }

    }

    // Query que permita insertar un contacto
    fun addContacto(contacto: Contacto){
        try {
            val db = AppContactos.DB.writableDatabase
            var qry = "INSERT INTO ${AppContactos.TB_CONTACTOS}("+
                    "${Contract.Contacto.NOMBRE}, ${Contract.Contacto.NUMERO} "+
                    "VALUES('${contacto.nombre}','${contacto.numero}');"
            db.execSQL(qry)
            db.close()
        }catch (ex:Exception){
            Toast.makeText(AppContactos.CONTEXT,"No se pudo guardar el contacto",Toast.LENGTH_SHORT).show()
        }
    }
}