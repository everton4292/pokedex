package com.pessoadev.pokedexproject.list.domain

import com.pessoadev.pokedexproject.list.model.PokeListResponse
import com.pessoadev.pokedexproject.list.service.ListService
import javax.inject.Inject

interface ListRepository {
    suspend fun getPokeList(): PokeListResponse
}

class ListRepositoryImpl @Inject constructor(private val listService: ListService) :
    ListRepository {

    override suspend fun getPokeList(): PokeListResponse = listService.getPokeList(10, 0)
}