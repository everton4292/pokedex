package com.pessoadev.pokedexproject.list.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.pessoadev.pokedexproject.list.domain.ListInteractor
import com.pessoadev.pokedexproject.list.domain.model.PokeList
import kotlinx.coroutines.launch
import java.lang.Exception


class ListViewModel @ViewModelInject constructor(private val listInteractor: ListInteractor) : ViewModel() {

    var pokeList = MutableLiveData<PokeList>().apply { mutableListOf<PokeList>() }

    fun getPokeList() {
        viewModelScope.launch {
            try {
                pokeList.value = listInteractor.getPokeList()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}