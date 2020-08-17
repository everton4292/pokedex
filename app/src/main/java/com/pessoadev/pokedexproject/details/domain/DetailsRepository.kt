package com.pessoadev.pokedexproject.details.domain

import com.pessoadev.pokedexproject.commons.NetworkModule
import com.pessoadev.pokedexproject.details.model.PokeDetailsResponse


class DetailsRepository{

    private val service = NetworkModule().getDetailsService()

    suspend fun getPokeDetails(): PokeDetailsResponse = service.getPokeDetails("ditto")
}