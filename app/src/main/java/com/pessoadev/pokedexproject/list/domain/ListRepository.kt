package com.pessoadev.pokedexproject.list.domain

import com.pessoadev.pokedexproject.commons.PokedexRepository
import com.pessoadev.pokedexproject.list.model.PokeListResponse
import javax.inject.Inject

interface ListRepository {
    suspend fun getPokeList(): PokeListResponse
}

class ListRepositoryImpl @Inject constructor(pokeDexRepository: PokedexRepository): ListRepository {

    private val service = pokeDexRepository.getListService()

    override suspend fun getPokeList(): PokeListResponse = service.getPokeList(1, 1)
}