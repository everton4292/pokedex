package com.pessoadev.pokedexproject.list.domain

import com.pessoadev.pokedexproject.commons.NetworkModule
import com.pessoadev.pokedexproject.list.model.PokeListResponse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class ListRepository @Inject constructor(){

    private val service = NetworkModule().getListService()

    suspend fun getPokeList(): PokeListResponse = service.getPokeList(1, 1)
}