package com.diegocastro.anchorbooks.mapper

import com.diegocastro.anchorbooks.db.LibroEntity
import com.diegocastro.anchorbooks.modelo.Libro

class LibroMapper {
    companion object {
        fun toEntity(libro: Libro):LibroEntity {
            with(libro) {
                return LibroEntity(
                    id, autor, pais, imagen, lenguaje, enlace, paginas, titulo, anno, precio, ultimoPrecio, despacho
                )
            }
        }
    }
}