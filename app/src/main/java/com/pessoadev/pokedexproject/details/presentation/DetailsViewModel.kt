package com.pessoadev.pokedexproject.details.presentation

import com.pessoadev.pokedexproject.details.domain.DetailsRepository
import com.pessoadev.pokedexproject.details.model.PokeDetailsResponse
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailsViewModel : ViewModel() {

    private val detailsRepository = DetailsRepository()

    var pokeDetailsResponse =
        MutableLiveData<PokeDetailsResponse>().apply { mutableListOf<PokeDetailsResponse>() }

    fun getPokeDetails() {
        viewModelScope.launch {
            try {
                pokeDetailsResponse.value = detailsRepository.getPokeDetails()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}