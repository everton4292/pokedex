package com.pessoadev.pokedexproject.details.di/*
package com.pessoadev.pokedexproject.details.di

import com.pessoadev.pokedexproject.details.domain.com.pessoadev.pokedexproject.details.domain.DetailsRepository
import com.pessoadev.pokedexproject.details.service.DetailsService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {
    @Singleton
    @Binds
    abstract fun bindDetailsRepository(
        detailsRepository: com.pessoadev.pokedexproject.details.domain.DetailsRepository
    ): DetailsService
}*/
