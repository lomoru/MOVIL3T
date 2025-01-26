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

public class pokeFragment extends Fragment {

    private FragmentPokeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentPokeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Crear lista de nombres de Pokémon
        List<String> pokemonList = getPokemonList();

        // Configurar el RecyclerView
        PokemonAdapter adapter = new PokemonAdapter(pokemonList);
        binding.pokedexRecy.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.pokedexRecy.setAdapter(adapter);
    }

    private List<String> getPokemonList() {
        List<String> pokemonList = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            pokemonList.add("Pokémon " + i);
        }
        return pokemonList;
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


