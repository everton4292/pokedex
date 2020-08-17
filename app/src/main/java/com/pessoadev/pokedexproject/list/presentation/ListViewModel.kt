package com.pessoadev.pokedexproject.list.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.pessoadev.pokedexproject.list.domain.ListRepositoryImpl
import com.pessoadev.pokedexproject.list.model.PokeListResponse
import kotlinx.coroutines.launch
import java.lang.Exception


class ListViewModel @ViewModelInject constructor(private val listRepository: ListRepositoryImpl) : ViewModel() {

    var pokeList = MutableLiveData<PokeListResponse>().apply { mutableListOf<PokeListResponse>() }

    fun getPokeList() {
        viewModelScope.launch {
            try {
                pokeList.value = listRepository.getPokeList()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}