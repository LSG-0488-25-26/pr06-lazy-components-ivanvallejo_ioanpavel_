package com.example.pokemonapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.pokemonapi.ui.theme.PokemonApiTheme
import com.example.pokemonapi.viewModel.PokemonViewModel
import com.example.pokemonapi.view.PokemonListScreen

class MainActivity : ComponentActivity() {

    private val pokemonViewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonApiTheme {
                val pokemons by pokemonViewModel.pokemonList.observeAsState(emptyList())

                Scaffold { innerPadding ->
                    PokemonListScreen(
                        pokemons = pokemons,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}