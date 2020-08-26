package com.pessoadev.pokedexproject.details.presentation

import androidx.hilt.lifecycle.ViewModelInject
import com.pessoadev.pokedexproject.details.domain.DetailsRepository
import com.pessoadev.pokedexproject.details.model.PokeDetailsResponse
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailsViewModel @ViewModelInject constructor(private val detailsRepository: DetailsRepository) :
    ViewModel() {

    var pokeDetailsResponse =
        MutableLiveData<PokeDetailsResponse>().apply { mutableListOf<PokeDetailsResponse>() }

    fun getPokeDetails(url : String) {
        viewModelScope.launch {
            try {
              pokeDetailsResponse.value = detailsRepository.getPokeDetails(url)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}