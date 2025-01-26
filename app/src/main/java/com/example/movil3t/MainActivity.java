package com.example.movil3t;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.movil3t.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inicializa el binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //componenete de navegación
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.pokcapFragment, R.id.pokeFragment, R.id.ajusFragment)
                .build();
        //controlador de navegación
        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = NavHostFragment.findNavController(navHostFragment);
        }

        // Agregar nombres a las pestañas del TabLayout
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Capturados")); // Pestaña para Pokémon Capturados
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Pokédex")); // Pestaña para Pokédex
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Ajustes")); // Pestaña para Ajustes



        // Configurar el TabLayout para cambiar entre fragmentos
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        navController.navigate(R.id.pokcapFragment);
                        break;
                    case 1:
                        navController.navigate(R.id.pokeFragment);
                        break;
                    case 2:
                        navController.navigate(R.id.ajusFragment);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    public void pokeClicked(Pokemon poke, View view){

    }
}