package com.example.movil3t;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movil3t.databinding.FragmentPokcapBinding;


public class pokcapFragment extends Fragment {

    private FragmentPokcapBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentPokcapBinding.inflate(inflater,container,false);

        binding.textini.setText("fragmento pokemom capturados");

        return binding.getRoot();
    }


}