package com.pessoadev.pokedexproject.list.presentation

import androidx.lifecycle.*
import com.pessoadev.pokedexproject.list.domain.ListRepository
import com.pessoadev.pokedexproject.list.model.PokeListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {

    //todo - precisar ir para o DI
    private val listRepository = ListRepository()

    var pokeList =  MutableLiveData<PokeListResponse>().apply { mutableListOf<PokeListResponse>() }

    fun getPokeList() {
        viewModelScope.launch {
            pokeList.value = listRepository.getPokeList()
        }
    }

}