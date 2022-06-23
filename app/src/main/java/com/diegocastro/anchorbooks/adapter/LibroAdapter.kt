package com.diegocastro.anchorbooks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegocastro.anchorbooks.databinding.LibroItemBinding
import com.diegocastro.anchorbooks.modelo.Libro
import com.squareup.picasso.Picasso

class LibroAdapter (private val datos:List<Libro>):RecyclerView.Adapter<LibroAdapter.ViewHolder>() {

    //creamos la clase interna
    class ViewHolder(val binding:LibroItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LibroItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val libro=datos.get(position)
        holder.binding.tvTitulo.text=libro.titulo
        holder.binding.tvAutor.text="Autor: ${libro.autor}"
        holder.binding.tvLenguaje.text="Lenguaje: ${libro.lenguaje}"
        holder.binding.tvPais.text="País: ${libro.pais}"
        Picasso.get().load(libro.imagen).into(holder.binding.imageView)

    }

    override fun getItemCount(): Int {
                return datos.size
    }
}