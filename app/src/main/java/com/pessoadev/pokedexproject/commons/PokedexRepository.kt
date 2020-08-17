package com.pessoadev.pokedexproject.commons

import com.pessoadev.pokedexproject.details.service.DetailsService
import com.pessoadev.pokedexproject.list.service.ListService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

interface PokedexRepository {
    fun getDetailsService(): DetailsService

}

class PokedexRepositoryImpl @Inject constructor(private val retrofit: Retrofit) :
    PokedexRepository {

    override fun getDetailsService(): DetailsService = retrofit.create(DetailsService::class.java)
}