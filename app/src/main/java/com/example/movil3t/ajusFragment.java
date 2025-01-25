package com.example.movil3t;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movil3t.databinding.FragmentAjusBinding;
import com.example.movil3t.databinding.FragmentPokeBinding;

public class ajusFragment extends Fragment {


    private FragmentAjusBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentAjusBinding.inflate(inflater,container,false);

        binding.textotres.setText("fragmento ajustes");

        return binding.getRoot();
    }
}