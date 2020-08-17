package com.pessoadev.pokedexproject.list.domain

import android.content.Context
import com.pessoadev.pokedexproject.commons.NetworkModule
import com.pessoadev.pokedexproject.list.model.PokeListResponse
import com.pessoadev.pokedexproject.list.service.ListService
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class ListRepository @Inject constructor(
    @ApplicationContext private val context: Context) : ListService {

    private val service = NetworkModule().getListService()

    //O código só funciona se tiver o override do getPokeList() da interface do ListService
    //Por outro lado, se removermos o suspend fun getPokeList() ---> O que não origina da interface
    //e logo não dá override, o view model não recebe os valores de limit e offset...
    suspend fun getPokeList(): PokeListResponse = service.getPokeList(1, 1)
    override suspend fun getPokeList(limit: Int, offset: Int): PokeListResponse = service.getPokeList(1, 1)

}