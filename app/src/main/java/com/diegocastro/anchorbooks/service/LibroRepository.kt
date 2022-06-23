package com.diegocastro.anchorbooks.service

import com.diegocastro.anchorbooks.modelo.Libro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LibroRepository {

    //Creamos la variable
    val libroAPI:LibroAPI

    //RETROFIT - Inicializa Retrofit
    init {
        val baseUrl = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/"

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        libroAPI = retrofit.create(LibroAPI::class.java)

    }

    //CORRUTINA se va a encargar de devolver los libros

    suspend fun findAll():List<Libro>{
        return withContext(Dispatchers.IO){
            val response =libroAPI.listLibros()
            response.body()?: emptyList()

        }

    }

}