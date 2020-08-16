package com.pessoadev.pokedexproject.details.service

import com.pessoadev.pokedexproject.details.model.PokeDetailsResponse

import retrofit2.http.GET
import retrofit2.http.Path


interface DetailsService {
    @GET("pokemon/{name}")
    suspend fun getPokeDetails(@Path("name") pokemonName: String): PokeDetailsResponse
}

