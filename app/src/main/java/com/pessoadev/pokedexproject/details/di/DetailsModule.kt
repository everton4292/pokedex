package com.pessoadev.pokedexproject.details.di

import com.pessoadev.pokedexproject.details.domain.DetailsRepository
import com.pessoadev.pokedexproject.details.domain.DetailsRepositoryImpl
import com.pessoadev.pokedexproject.details.service.DetailsService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
abstract class DetailsModule {
    @Binds
    abstract fun bindsDetailsRepository(detailsRepository: DetailsRepositoryImpl): DetailsRepository
}

@Module
@InstallIn(ApplicationComponent::class)
object DetailsServiceModule {
    @JvmStatic
    @Provides
    fun providesDetailsService(retrofit: Retrofit): DetailsService =
        retrofit.create(DetailsService::class.java)
}