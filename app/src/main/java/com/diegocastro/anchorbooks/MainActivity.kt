package com.diegocastro.anchorbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.diegocastro.anchorbooks.databinding.ActivityMainBinding
import com.diegocastro.anchorbooks.modelo.Libro
import com.diegocastro.anchorbooks.service.LibroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    //.1
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //.2
        binding=ActivityMainBinding.inflate(layoutInflater)

        //.3 cambiamos el argumento por binding.root
        setContentView(binding.root)

        //binding.textview1.text="Hola Mundillo uno!!!"
        //binding.textview2.text="Hola Mundillo dos!!!"

        val baseUrl = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/"

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val libroService = retrofit.create(LibroService::class.java)

        libroService.detailLibro(4).enqueue( object: Callback<Libro> {

            override fun onResponse(call: Call<Libro>, response: Response<Libro>) {
                val libro = response.body()
                binding.textview2.text=libro.toString()
                Log.d("RETROFIT","Cargando datos del libro")
            }

            override fun onFailure(call: Call<Libro>, t: Throwable) {
                t.printStackTrace()
                Log.e("RETROFIT", "Retrofit falló al traer los datos")
            }

        })
    }
}