package com.pessoadev.pokedexproject.list.domain

import com.pessoadev.pokedexproject.commons.NetworkModule
import com.pessoadev.pokedexproject.list.model.PokeListResponse

class ListRepository {

    private val service = NetworkModule().getListService()

    suspend fun getPokeList(): PokeListResponse = service.getPokeList(1, 1)
}