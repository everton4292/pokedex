package com.pessoadev.pokedexproject.details.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.pessoadev.pokedexproject.R



class DetailsActivity : AppCompatActivity() {

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPokeDetails()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.pokeDetailsResponse.observe(this, Observer {
            println(it.name)
            println(it.id)

        })
    }
}