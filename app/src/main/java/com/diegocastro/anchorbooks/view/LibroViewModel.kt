package com.diegocastro.anchorbooks.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegocastro.anchorbooks.modelo.Libro
import com.diegocastro.anchorbooks.service.LibroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibroViewModel @Inject constructor(val repo: LibroRepository): ViewModel() {

    val libros = MutableLiveData<List<Libro>>()

    fun cargarLibros() {
        viewModelScope.launch {
            val librosFromRepo = repo.findAll()
            if( !librosFromRepo.isNullOrEmpty() ) {
                libros.postValue(librosFromRepo)
            }
        }
    }
}