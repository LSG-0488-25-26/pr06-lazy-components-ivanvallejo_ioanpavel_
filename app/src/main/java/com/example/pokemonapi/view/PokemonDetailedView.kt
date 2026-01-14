package com.example.pokemonapi.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
    pokemon: Pokemon,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Name
            Text(
                text = pokemon.name,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )

            // Image
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.imageUrl)
                    .build(),
                contentDescription = pokemon.name,
                modifier = Modifier.size(250.dp)
            )

            // Details
            Text("ID", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text("${pokemon.id}", fontSize = 18.sp)


            Text("Type", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(pokemon.type, fontSize = 18.sp)

            Text("Description", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(pokemon.description, fontSize = 18.sp)
        }

        Button(
            onClick = { onBack() },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            Text("Volver")
        }
    }
}


/*@Preview(showBackground = true)
@Composable
fun PokeDetailInfoPreview(){
    val pk = Pokemon(1, "Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png", "Grass/Poison", "A strange seed was planted on its back at birth.")
    PokemonDetailedView(pokemon = pk)
}*/