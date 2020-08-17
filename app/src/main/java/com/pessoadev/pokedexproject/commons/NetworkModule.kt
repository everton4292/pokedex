package com.pessoadev.pokedexproject.commons

import com.pessoadev.pokedexproject.details.service.DetailsService
import com.pessoadev.pokedexproject.list.service.ListService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NetworkModule @Inject constructor(){

    private fun getService(): Retrofit {
        val okhttp = createOkHttpClient()
        return createRetrofit(okhttp, "https://pokeapi.co/api/v2/")
    }

    private fun createOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor).build()

    }

    private fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getListService (): ListService = NetworkModule().getService().create(ListService::class.java)
    fun getDetailsService (): DetailsService = NetworkModule().getService().create(DetailsService::class.java)
}