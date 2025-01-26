package com.example.movil3t;

import androidx.recyclerview.widget.RecyclerView;import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.view.View;

import com.example.movil3t.databinding.PokeCardviewBinding;

public class PokeRecyclerViewAdapter extends RecyclerView.Adapter<PokeViewHolder>{

    private final ArrayList<Pokemon> games;
    private final Context context;

    public PokeRecyclerViewAdapter(ArrayList<Pokemon> games, Context context) {
        this.games = games;
        this.context = context;
    }

    @NonNull
    @Override
    public PokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PokeCardviewBinding binding = PokeCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent,false
        );

        return new PokeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PokeViewHolder holder, int position) {
        Pokemon ahoraPokemon=this.games.get(position);
        holder.bind(ahoraPokemon);

        holder.itemView.setOnClickListener(view -> itemClicked(ahoraPokemon, view));
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    private void itemClicked(Pokemon currentPokemon, View view) {
        // Llama a la función gameClicked de MainActivity, pasando la vista

        if (context instanceof MainActivity) {
            ((MainActivity) context).pokeClicked(currentPokemon, view);
        }

    }


}
