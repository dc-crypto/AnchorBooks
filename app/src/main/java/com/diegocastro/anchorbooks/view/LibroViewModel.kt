package com.diegocastro.anchorbooks.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegocastro.anchorbooks.modelo.Libro
import com.diegocastro.anchorbooks.service.LibroRepository
import kotlinx.coroutines.launch

class LibroViewModel: ViewModel(){
    val libros = MutableLiveData<List<Libro>>()

    fun cargarLibros() {
        viewModelScope.launch {
            val repo = LibroRepository()
            val librosFromRepo = repo.findAll()
            if(!librosFromRepo.isNullOrEmpty()) {
                libros.postValue(librosFromRepo)
            }
        }
    }
}