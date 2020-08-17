package com.pessoadev.pokedexproject.list.di

import com.pessoadev.pokedexproject.list.domain.ListRepository
import com.pessoadev.pokedexproject.list.service.ListService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class ListModule {
    @Singleton
    @Binds
    abstract fun bindsListRepository(
        listRepository: ListRepository
    ): ListService
}

