package com.pessoadev.pokedexproject.details.service

import PokeDetailsResponse

import retrofit2.http.GET
import retrofit2.http.Path


interface DetailsService {
    @GET("https://pokeapi.co/api/v2/pokemon/{pokemonName}")
    suspend fun getPokeDetails(@Path("ditto") pokemonName: String): PokeDetailsResponse
}

