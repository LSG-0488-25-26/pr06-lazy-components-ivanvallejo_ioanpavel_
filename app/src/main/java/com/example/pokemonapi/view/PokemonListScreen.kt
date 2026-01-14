package com.example.pokemonapi.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokemonapi.model.Pokemon

@Composable
fun PokemonListScreen(pokemons: List<Pokemon>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Pokémon cargados: ${pokemons.size}")
        LazyColumn() {
            items(pokemons){ pokemon ->
                PokeCard(pokemon = pokemon)
            }
        }

    }
}