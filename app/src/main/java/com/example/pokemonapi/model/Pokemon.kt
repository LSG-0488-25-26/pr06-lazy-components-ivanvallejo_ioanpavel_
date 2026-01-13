package com.example.pokemonapi.model

data class Pokemon(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val type: String,
    val description: String
)