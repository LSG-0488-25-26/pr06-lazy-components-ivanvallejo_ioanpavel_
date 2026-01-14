package com.example.pokemonapi.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokemonapi.model.Pokemon

@Composable
fun PokemonDetailedView(
    pokemon: Pokemon
){
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.Center,

    ){
        Column(
            modifier = Modifier.align(Alignment.Center),
        ) {
            //Name
            Text(text = pokemon.name,
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp
            )
            //Img
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.imageUrl)
                    .build(),
                contentDescription = pokemon.name,
                modifier = Modifier
                    .size(250.dp)
                    .padding(end = 8.dp),
            )
            //details
            Text(
                text = "ID\n",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Text(
                text = "${pokemon.id}\n",
                fontSize = 20.sp
            )
            Text(
                text = "Type\n",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Text(
                text ="${pokemon.type}\n",
                fontSize = 20.sp
            )
            Text(
                text = "Description\n",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Text(
                text = pokemon.description,
                fontSize = 20.sp
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokeDetailInfoPreview(){
    val pk = Pokemon(1, "Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png", "Grass/Poison", "A strange seed was planted on its back at birth.")
    PokemonDetailedView(pokemon = pk)
}