package com.pessoadev.pokedexproject.list.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.pessoadev.pokedexproject.R

//@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPokeList()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.pokeList.observe(this, Observer {
            println(it.results.get(0).url)
        })
    }
}