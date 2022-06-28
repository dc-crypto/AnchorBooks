package com.diegocastro.anchorbooks.app

import android.app.Application
import androidx.room.Room
import com.diegocastro.anchorbooks.db.BaseDatos
import com.diegocastro.anchorbooks.service.LibroAPI
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class AnchorBooksApp : Application()