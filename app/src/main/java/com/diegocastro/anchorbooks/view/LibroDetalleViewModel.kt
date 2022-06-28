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
class LibroDetalleViewModel @Inject constructor(val repo: LibroRepository): ViewModel() {

    val libro = MutableLiveData<Libro>()

    fun cargarLibro(id:Int) {
        viewModelScope.launch {
            val libroFromRepo = repo.findById(id)
            if( libroFromRepo != null ) {
                libro.postValue(libroFromRepo)
            }
        }
    }
}