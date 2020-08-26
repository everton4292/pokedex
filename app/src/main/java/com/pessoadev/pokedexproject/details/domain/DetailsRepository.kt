package com.pessoadev.pokedexproject.details.domain

import com.pessoadev.pokedexproject.details.model.PokeDetailsResponse
import com.pessoadev.pokedexproject.details.service.DetailsService
import javax.inject.Inject


interface DetailsRepository {
    suspend fun getPokeDetails(url: String): PokeDetailsResponse
}

class DetailsRepositoryImpl @Inject constructor(private val detailsService: DetailsService) :
    DetailsRepository {

    override suspend fun getPokeDetails(url: String): PokeDetailsResponse {
        val urlArray = url.split("/")
        val pokemonId = urlArray[urlArray.size - 2]

        return detailsService.getPokeDetails(pokemonId)
    }
}
