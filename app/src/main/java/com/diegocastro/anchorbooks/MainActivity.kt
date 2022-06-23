package com.diegocastro.anchorbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegocastro.anchorbooks.adapter.LibroAdapter
import com.diegocastro.anchorbooks.databinding.ActivityMainBinding
import com.diegocastro.anchorbooks.view.LibroViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //VIEWMODEL
    private val libroViewModel:LibroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //RECYCLER VIEW
        val recyclerView =binding.recyclerView
        recyclerView.layoutManager=LinearLayoutManager(this)

        //LLAMA A LA FUNCIÓN
        libroViewModel.cargarLibros()

        //OBSERVER
        libroViewModel.libros.observe(this, Observer { libros ->
            binding.recyclerView.adapter=LibroAdapter(libros)
        })


    }
}