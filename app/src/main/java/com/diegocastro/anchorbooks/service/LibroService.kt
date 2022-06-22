package com.diegocastro.anchorbooks.service

import com.diegocastro.anchorbooks.modelo.Libro
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LibroService {
    @GET("books")
    fun listLibros(): Call<List<Libro>>

    @GET("bookDetail/{id}")
    fun detailLibro(@Path("id") libroId:Int): Call<Libro>

    //https://square.github.io/retrofit/
}