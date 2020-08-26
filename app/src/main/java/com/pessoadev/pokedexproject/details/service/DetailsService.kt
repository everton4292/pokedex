package com.pessoadev.pokedexproject.details.service

import com.pessoadev.pokedexproject.details.model.PokeDetailsResponse

import retrofit2.http.GET
import retrofit2.http.Path


interface DetailsService {
    @GET("pokemon/{pokemonId}")
    suspend fun getPokeDetails(@Path("pokemonId") pokemonId: String): PokeDetailsResponse
}

