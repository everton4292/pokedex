package com.pessoadev.pokedexproject.list.di

import com.pessoadev.pokedexproject.list.data.ListRepository
import com.pessoadev.pokedexproject.list.data.ListRepositoryImpl
import com.pessoadev.pokedexproject.list.data.service.ListService
import com.pessoadev.pokedexproject.list.domain.ListInteractor
import com.pessoadev.pokedexproject.list.domain.ListInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
abstract class ListModule {

    @Binds
    abstract fun bindsListRepository(listRepository: ListRepositoryImpl): ListRepository

    @Binds
    abstract fun bindsListInteractor(listInteractor: ListInteractorImpl): ListInteractor
}

@Module
@InstallIn(ActivityComponent::class)
object ListServiceModule {
    @JvmStatic
    @Provides
    fun provideListService(retrofit: Retrofit): ListService =
        retrofit.create(ListService::class.java)

    @JvmStatic
    @Provides
    fun provideListAdapter() : com.pessoadev.pokedexproject.list.presentation.ListAdapter
            = com.pessoadev.pokedexproject.list.presentation.ListAdapter()
}



