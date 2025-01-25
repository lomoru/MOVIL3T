package com.example.movil3t;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movil3t.databinding.FragmentPokcapBinding;
import com.example.movil3t.databinding.FragmentPokeBinding;

public class pokeFragment extends Fragment {

    private FragmentPokeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentPokeBinding.inflate(inflater,container,false);

        binding.textinidos.setText("fragmento pokedex");

        return binding.getRoot();
    }

}