package com.diegocastro.anchorbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.diegocastro.anchorbooks.databinding.ActivityDetalleBinding
import com.diegocastro.anchorbooks.db.BaseDatos
import com.diegocastro.anchorbooks.db.LibroEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetalleActivity : AppCompatActivity() {

    //VIEWBINDING
    private lateinit var binding:ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //CORRUTINA
        GlobalScope.launch {
            val db= Room.databaseBuilder(
                applicationContext,
                BaseDatos::class.java,
                "libros-db"
            ).build()

            val libroDao=db.libroDao()

            //METODO BORRARTODO EVITA PROBLEMAS DE PRIMARY KEY
            libroDao.deleteAll()

            //PROBAMOS METODO DE INSERCION
            libroDao.insertAll(
                LibroEntity(
                    1,
                    "Juan perez",
                    "Chile",
                    "http://example.com/img.jpg",
                    "español",
                    "http://juanito.cl",
                    110,
                    "Lorem Ipsum",
                    2019,
                    25000,
                    30000,
                    true
                    ),
                LibroEntity(
                    2,
                    "Cata Gonzalez",
                    "Argentina",
                    "http://example.com/img.jpg",
                    "español",
                    "http://juanito.cl",
                    120,
                    "Lorem Ipsum",
                    2019,
                    30000,
                    40000,
                    true
                ),
                LibroEntity(
                    3,
                    "Carlos Payulis",
                    "Argentina",
                    "http://example.com/img.jpg",
                    "español",
                    "http://juanito.cl",
                    120,
                    "Lorem Ipsum",
                    2020,
                    40000,
                    50000,
                    true
                )

            )

            //PROBAMOS METODO TRAER_TODO DE BD
            val libros = libroDao.getAll()

            //BINDING EN EL TEXTVIEW DE PRUEBA
            binding.textView.text=libros.toString()
        }
    }
}