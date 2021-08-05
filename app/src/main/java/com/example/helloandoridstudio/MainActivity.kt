package com.example.helloandoridstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val contactoAdmin = AdminContacto()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        crearLista()
    }
    fun crearLista(){
        val nombres = contactoAdmin.getAllNames()
        val adaptador = ArrayAdapter(AppContactos.CONTEXT,android.R.layout.simple_expandable_list_item_1,nombres!!.toMutableList())
        listContactos.adapter = adaptador
        listContactos.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val item = nombres!!.get(i)
            Toast.makeText(AppContactos.CONTEXT, item, Toast.LENGTH_SHORT).show()
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item!!.itemId){
            R.id.action_add -> {
                val intentAdd = Intent(applicationContext,AgregarContacto::class.java)
                startActivity(intentAdd)
                return true
            }
            else ->  return super.onOptionsItemSelected(item)
        }

    }
}