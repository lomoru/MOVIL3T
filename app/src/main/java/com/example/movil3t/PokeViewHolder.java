package com.example.movil3t;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movil3t.databinding.PokeCardviewBinding;

public class PokeViewHolder extends RecyclerView.ViewHolder{

    private final PokeCardviewBinding binding;



    public PokeViewHolder(PokeCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (Pokemon pokemon){
        binding.nombre.setText(pokemon.getNombre());
        binding.altura.setText(String.valueOf(pokemon.getAltura()));
        binding.peso.setText(String.valueOf(pokemon.getPeso()));
        binding.tipo.setText(pokemon.getTipo());
    }
}
