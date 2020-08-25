package com.pessoadev.pokedexproject.details.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.pessoadev.pokedexproject.R
import com.pessoadev.pokedexproject.list.model.Pokemon
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.details_activity.*


@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val viewModel: DetailsViewModel by viewModels()
    //var pokemonName = intent.getStringExtra("POKEMON_NAME")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        viewModel.getPokeDetails()
        setupObservers()

        //textViewPokemonName.text = pokemonName
    }

    private fun setupObservers() {
        viewModel.pokeDetailsResponse.observe(this, Observer {
            println(it.name)
            println(it.id)

        })
    }
}