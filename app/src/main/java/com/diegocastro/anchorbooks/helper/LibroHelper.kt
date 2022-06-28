package com.diegocastro.anchorbooks.helper

import com.diegocastro.anchorbooks.modelo.LibroModel

class LibroHelper {
    companion object {
        fun emptyLibroModel():LibroModel {
            return LibroModel(
                0,
                "Sin info",
                "Sin info",
                "https://via.placeholder.com/140x100",
                "Sin info",
                "Sin info",
                0,
                "Sin info",
                0,
                0,
                0,
                false
            )
        }
    }
}