package com.pessoadev.pokedexproject.list.data

import com.pessoadev.pokedexproject.list.data.model.PokeListResponse
import com.pessoadev.pokedexproject.list.data.service.ListService
import javax.inject.Inject

interface ListRepository {
    suspend fun getPokeList(): PokeListResponse
}

class ListRepositoryImpl @Inject constructor(private val listService: ListService) :
    ListRepository {

    override suspend fun getPokeList(): PokeListResponse = listService.getPokeList(10, 0)
}