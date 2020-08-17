package com.pessoadev.pokedexproject.list.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pessoadev.pokedexproject.R
import com.pessoadev.pokedexproject.list.model.PokeListResponse



class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private val result: MutableList<PokeListResponse> = mutableListOf()

    fun insertData(result: MutableList<PokeListResponse>) {
        this.result.addAll(result)

        notifyDataSetChanged()
    }


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val cellRowList =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_row, parent, false)
        return ListViewHolder(cellRowList)
    }

    override fun getItemCount(): Int {
        return result.size

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

    }
}












