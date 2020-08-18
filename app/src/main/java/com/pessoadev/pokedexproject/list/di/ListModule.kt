package com.pessoadev.pokedexproject.list.di

import com.pessoadev.pokedexproject.list.domain.ListRepository
import com.pessoadev.pokedexproject.list.domain.ListRepositoryImpl
import com.pessoadev.pokedexproject.list.service.ListService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

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



