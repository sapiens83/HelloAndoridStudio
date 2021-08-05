package com.example.helloandoridstudio

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class InitDb:SQLiteOpenHelper(AppContactos.CONTEXT,AppContactos.DB_NAME,null,AppContactos.VERSION) {
    val qryCreateTabla = "CREATE TABLE ${AppContactos.TB_CONTACTOS}(" +
            "${Contract.Contacto.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "${Contract.Contacto.NOMBRE} TEXT NOT NULL," +
            "${Contract.Contacto.NUMERO} TEXT NOT NULL); "

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(qryCreateTabla)
    }
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }


}