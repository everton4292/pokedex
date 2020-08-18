package com.pessoadev.pokedexproject.list.model

data class PokeListResponse(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<Pokemon>
)

data class Pokemon(
    val name: String,
    val url: String
)