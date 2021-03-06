package com.pessoadev.pokedexproject.list.presentation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pessoadev.pokedexproject.R
import com.pessoadev.pokedexproject.details.presentation.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class ListActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val viewModel: ListViewModel by viewModels()

    @Inject lateinit var listAdapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewPokeList.layoutManager = LinearLayoutManager(this)
        recyclerViewPokeList.adapter = listAdapter
        (recyclerViewPokeList.adapter as ListAdapter).setOnPokemonListener { url ->
            val intent = Intent(this, DetailsActivity::class.java)
                .apply { putExtra(POKEMON_URL_PARAM, url) }
            startActivity(intent)
        }

        viewModel.getPokeList()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.pokeList.observe(this, Observer {
            (recyclerViewPokeList.adapter as ListAdapter).insertData(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView =
            searchItem?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

    companion object {
        const val POKEMON_URL_PARAM = "POKEMON_URL"
    }
}