package com.diegocastro.anchorbooks.service

import androidx.room.Room
import com.diegocastro.anchorbooks.db.BaseDatos
import com.diegocastro.anchorbooks.db.LibroDao
import com.diegocastro.anchorbooks.helper.LibroHelper
import com.diegocastro.anchorbooks.mapper.LibroMapper
import com.diegocastro.anchorbooks.modelo.Libro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class LibroRepository @Inject constructor(
    val libroAPI:LibroAPI,
    val libroDao:LibroDao
) {

    suspend fun findById(id:Int):Libro {
        return withContext(Dispatchers.IO) {
            val response = libroAPI.detailLibro(id)
            if( response.isSuccessful ) {
                val libro = response.body() ?: LibroHelper.emptyLibroModel()

                // cachear en BD
                libroDao.insertAll(LibroMapper.toEntity(libro))

                libro
            } else {
                libroDao.findById(id)
            }
        }
    }

    suspend fun findAll():List<Libro> {
        return withContext(Dispatchers.IO) {
            val response = libroAPI.listLibros()
            if( response.isSuccessful ) {
                val libros = response.body() ?: emptyList()

                // borra cache antigua
                libroDao.deleteAll()
                // cachear datos en BD
                libros.forEach { libroModel ->
                    libroDao.insertAll( LibroMapper.toEntity(libroModel) )
                }

                libros
            }else {
                libroDao.getAll()
            }
        }
    }

}