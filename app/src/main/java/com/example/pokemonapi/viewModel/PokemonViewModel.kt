package com.example.pokemonapi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonapi.model.Pokemon

class PokemonViewModel : ViewModel() {

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    private val _selectedPokemon = MutableLiveData<Pokemon>()
    val selectedPokemon: LiveData<Pokemon> = _selectedPokemon

    init {
        loadPokemonData()
    }

    private fun loadPokemonData() {
        val list = listOf(
            Pokemon(1, "Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png", "Grass/Poison", "A strange seed was planted on its back at birth."),
            Pokemon(4, "Charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png", "Fire", "The flame on its tail indicates its life force."),
            Pokemon(7, "Squirtle", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/7.png", "Water", "Shoots water at prey while retreating into its shell."),
            Pokemon(25, "Pikachu", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png", "Electric", "When several of these Pokémon gather, their electricity could build and cause lightning storms."),
            Pokemon(133, "Eevee", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/133.png", "Normal", "Its genetic code is irregular. It may mutate if it is exposed to radiation from element stones."),
            Pokemon(150, "Mewtwo", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/150.png", "Psychic", "It was created by a scientist after years of horrific gene splicing and DNA engineering experiments."),
            Pokemon(94, "Gengar", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/94.png", "Ghost/Poison", "Hides in shadows. It is said that if Gengar is lurking, it cools the area by nearly 10 degrees."),
            Pokemon(143, "Snorlax", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/143.png", "Normal", "Its stomach can digest any kind of food, even if it happens to be a little moldy.")
        )
        _pokemonList.value = list
    }

    fun selectPokemon(pokemon: Pokemon) {
        _selectedPokemon.value = pokemon
    }
}