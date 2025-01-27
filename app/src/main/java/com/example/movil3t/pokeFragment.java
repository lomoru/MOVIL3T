package com.example.movil3t;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movil3t.databinding.FragmentPokeBinding;
import com.example.movil3t.databinding.ItemPokemonBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pokeFragment extends Fragment {

    private FragmentPokeBinding binding;
    private PokemonAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentPokeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Crear lista de nombres de Pokémon
        List<String> pokemonList = new ArrayList<>();

        // Configurar el RecyclerView
        adapter = new PokemonAdapter(pokemonList);
        binding.pokedexRecy.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.pokedexRecy.setAdapter(adapter);

        //llenar de nombres
        fetchPokemonData();
    }

    //Clase para llamar a la api y obtener los datos
    private void fetchPokemonData() {
        // Crear instancia del servicio Retrofit
        PokemonApiService apiService = RetrofitClient.getRetrofitInstance().create(PokemonApiService.class);
        Call<PokemonResponse> call = apiService.getPokemonList();

        // Realizar la llamada asincrónica
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<PokemonResponse.PokemonName> pokemonList = response.body().getResults();
                    List<String> pokemonNames = new ArrayList<>();
                    for (PokemonResponse.PokemonName pokemon : pokemonList) {
                        pokemonNames.add(pokemon.getName());
                    }
                    // Actualizar el adaptador con los nombres obtenidos
                    adapter.updateData(pokemonNames);
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                // Manejar errores
                t.printStackTrace();
            }
        });
    }



    // Clase interna para el adaptador
    private static class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

        private final List<String> pokemonList;


        public PokemonAdapter(List<String> pokemonList) {
            this.pokemonList = pokemonList;
        }

        @NonNull
        @Override
        public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemPokemonBinding binding1=ItemPokemonBinding.inflate(
                    LayoutInflater.from(parent.getContext()),parent,false
            );

            return new PokemonViewHolder(binding1);
        }

        @Override
        public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
            String pokemonName = pokemonList.get(position);
            holder.binding3.pokemonName.setText(pokemonName);

        }

        @Override
        public int getItemCount() {
            return pokemonList.size();
        }

        // Método para actualizar los datos del adaptador
        public void updateData(List<String> newPokemonList) {
            pokemonList.clear();
            pokemonList.addAll(newPokemonList);
            notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
        }



        //clase interna para el viewHolder
        static class PokemonViewHolder extends RecyclerView.ViewHolder {
            private final ItemPokemonBinding binding3;

            public PokemonViewHolder(ItemPokemonBinding binding3) {
                super(binding3.getRoot());
                this.binding3 = binding3;

            }
        }
    }
}


