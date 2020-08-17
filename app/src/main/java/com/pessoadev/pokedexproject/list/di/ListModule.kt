package com.pessoadev.pokedexproject.list.di

import com.pessoadev.pokedexproject.commons.PokedexRepository
import com.pessoadev.pokedexproject.commons.PokedexRepositoryImpl
import com.pessoadev.pokedexproject.list.domain.ListRepository
import com.pessoadev.pokedexproject.list.domain.ListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class ListModule {

    @Binds
    abstract fun bindsListRepository(listRepository: ListRepositoryImpl): ListRepository

    @Binds
    abstract fun bindsNetworkModule(pokedexRepositoryImpl: PokedexRepositoryImpl): PokedexRepository

}

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okhttp = OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor).build()

        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .client(okhttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

