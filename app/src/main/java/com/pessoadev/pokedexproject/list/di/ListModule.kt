package com.pessoadev.pokedexproject.list.di

import com.pessoadev.pokedexproject.commons.PokedexRepository
import com.pessoadev.pokedexproject.commons.PokedexRepositoryImpl
import com.pessoadev.pokedexproject.list.domain.ListRepository
import com.pessoadev.pokedexproject.list.domain.ListRepositoryImpl
import com.pessoadev.pokedexproject.list.service.ListService
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

}

@Module
@InstallIn(ApplicationComponent::class)
object ListServiceModule {
    @JvmStatic
    @Provides
    fun provideListService(retrofit: Retrofit): ListService =
        retrofit.create(ListService::class.java)
}



