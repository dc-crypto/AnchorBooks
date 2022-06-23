package com.diegocastro.anchorbooks.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface LibroDao {

    @Query("SELECT * FROM libros")
    fun getAll(): List<LibroEntity>

    @Query("SELECT * FROM libros WHERE id = :lid")
    fun findById(lid:Int): LibroEntity

    @Insert
    fun insertAll(vararg libros:LibroEntity)

    @Delete
    fun delete(libro:LibroEntity)
}