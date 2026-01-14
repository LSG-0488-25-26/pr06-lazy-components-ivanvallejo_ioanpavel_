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
import com.example.pokemonapi.view.PokemonDetailedView
import com.example.pokemonapi.view.PokemonListScreen
import com.example.pokemonapi.viewModel.PokemonViewModel

class MainActivity : ComponentActivity() {

    private val pokemonViewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PokemonApiTheme {
                val pokemons by pokemonViewModel.pokemonList.observeAsState(emptyList())
                val selectedPokemon by pokemonViewModel.selectedPokemon.observeAsState()

                Scaffold { innerPadding ->
                    if (selectedPokemon == null) {
                        PokemonListScreen(
                            pokemons = pokemons,
                            modifier = Modifier.padding(innerPadding),
                            onPokemonClick = { pokemon ->
                                pokemonViewModel.selectPokemon(pokemon)
                            }
                        )
                    } else {
                        PokemonDetailedView(
                            pokemon = selectedPokemon!!,
                            onBack = {
                                pokemonViewModel.clearSelectedPokemon()
                            }
                        )
                    }
                }
            }
        }
    }
}
