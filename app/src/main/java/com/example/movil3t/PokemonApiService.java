package com.example.movil3t;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonApiService {
    @GET("pokemon?limit=25") // Endpoint para obtener los primeros 25 Pokémon
    Call<PokemonResponse> getPokemonList();
}