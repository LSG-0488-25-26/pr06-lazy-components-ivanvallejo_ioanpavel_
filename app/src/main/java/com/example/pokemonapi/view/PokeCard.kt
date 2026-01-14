package com.example.pokemonapi.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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
import com.example.pokemonapi.ui.theme.Blue
import com.example.pokemonapi.ui.theme.Gray

@Composable
fun PokeCard(pokemon: Pokemon) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.imageUrl)
                    .build(),
                contentDescription = pokemon.name,
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 16.dp),
            )

            // Información
            Column {
                Text(
                    text = pokemon.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "ID: ${pokemon.id}",
                    fontSize = 14.sp,
                    color = Gray
                )
                Text(
                    text = "Type: ${pokemon.type}",
                    fontSize = 14.sp,
                    color = Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokecardPreview(){
    val pk = Pokemon(1, "Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png", "Grass/Poison", "A strange seed was planted on its back at birth.")
    PokeCard(pokemon = pk)
}
