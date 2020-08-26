package com.pessoadev.pokedexproject.list.domain

import com.pessoadev.pokedexproject.list.data.ListRepository
import com.pessoadev.pokedexproject.list.data.model.PokeListResponse
import com.pessoadev.pokedexproject.list.domain.model.PokeList
import com.pessoadev.pokedexproject.list.domain.model.Pokemon
import javax.inject.Inject

interface ListInteractor {
    suspend fun getPokeList(): PokeList
}

class ListInteractorImpl @Inject constructor(private val listRepository: ListRepository) :
    ListInteractor {

    override suspend fun getPokeList(): PokeList {
        return listRepository.getPokeList().toPokeList()
    }

    private fun PokeListResponse.toPokeList(): PokeList {
        return PokeList(
            this.count,
            this.next,
            this.previous,
            this.results.map { pokemonResponse -> Pokemon(pokemonResponse.name, pokemonResponse.url) }
        )
    }

}