package com.example.movil3t;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movil3t.databinding.FragmentPokcapBinding;

import java.util.ArrayList;


public class pokcapFragment extends Fragment {

    private FragmentPokcapBinding binding;
    private ArrayList<Pokemon> listapokemons;
    private PokeRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentPokcapBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listapokemons=cargarPokemones();

        adapter=new PokeRecyclerViewAdapter(listapokemons,getActivity());
        binding.pokeRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.pokeRecyclerview.setAdapter(adapter);

    }

    public static ArrayList<Pokemon> cargarPokemones() {
        ArrayList<Pokemon> pokemones = new ArrayList<>();

        String rutaImagen = "R.drawable.pikachu";

        // Creación de cinco objetos Pokémon con datos de ejemplo
        pokemones.add(new Pokemon("Pikachu", 25, "Eléctrico", 60, 40, rutaImagen));
        pokemones.add(new Pokemon("Charmander", 4, "Fuego", 85, 60, rutaImagen));
        pokemones.add(new Pokemon("Bulbasaur", 1, "Planta", 69, 70, rutaImagen));
        pokemones.add(new Pokemon("Squirtle", 7, "Agua", 90, 50, rutaImagen));
        pokemones.add(new Pokemon("Eevee", 133, "Normal", 65, 30, rutaImagen));

        return pokemones;
    }


}