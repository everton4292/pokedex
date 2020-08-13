package com.pessoadev.pokedexproject.list.service


import com.pessoadev.pokedexproject.list.model.PokeListResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ListService {

    @GET("pokemon")
    suspend fun getPokeList(@Query("limit") limit : Int, @Query("offset") offset : Int) : PokeListResponse

}