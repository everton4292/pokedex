package com.pessoadev.pokedexproject.list.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pessoadev.pokedexproject.R
import com.pessoadev.pokedexproject.list.model.PokeListResponse
import com.pessoadev.pokedexproject.list.model.Pokemon
import kotlinx.android.synthetic.main.pokemon_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    lateinit var pokemonListener: OnPokemonClickListener
    private val pokemonList: MutableList<Pokemon> = mutableListOf()

    fun insertData(pokeList: PokeListResponse) {
        val pokemons = pokeList.results.map { it }
        pokemonList.addAll(pokemons)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pokemon: Pokemon) {
            itemView.pokemonName.text = pokemon.name
            itemView.setOnClickListener {
                pokemonListener.onClick(pokemon.url)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val cellRowList =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_row, parent, false)
        return ListViewHolder(cellRowList)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): Pokemon {
        return pokemonList[position]
    }

    interface OnPokemonClickListener {
        fun onClick(url: String) = Unit
    }

    inline fun setOnPokemonListener(crossinline listener: (String) -> Unit) {
        this.pokemonListener = object : OnPokemonClickListener {
            override fun onClick(url: String) = listener(url)
        }
    }

}