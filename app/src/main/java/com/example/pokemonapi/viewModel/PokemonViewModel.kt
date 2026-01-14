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
            // Kanto Starters
            Pokemon(1, "Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png", "Grass/Poison", "A strange seed was planted on its back at birth."),
            Pokemon(4, "Charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png", "Fire", "The flame on its tail indicates its life force."),
            Pokemon(7, "Squirtle", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/7.png", "Water", "Shoots water at prey while retreating into its shell."),

            // Kanto Evolutions
            Pokemon(2, "Ivysaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png", "Grass/Poison", "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs."),
            Pokemon(5, "Charmeleon", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/5.png", "Fire", "Tough fights could excite this Pokémon. When excited, it may blow out bluish-white flames."),
            Pokemon(8, "Wartortle", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/8.png", "Water", "It often hides in water to stalk unwary prey. For fast swimming, it moves its ears to maintain balance."),
            Pokemon(3, "Venusaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png", "Grass/Poison", "The plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight."),
            Pokemon(6, "Charizard", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/6.png", "Fire/Flying", "Spits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally."),
            Pokemon(9, "Blastoise", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/9.png", "Water", "The rocket cannons on its shell fire jets of water capable of punching holes through thick steel."),

            // Electric Types
            Pokemon(25, "Pikachu", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png", "Electric", "When several of these Pokémon gather, their electricity could build and cause lightning storms."),
            Pokemon(26, "Raichu", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/26.png", "Electric", "Its long tail serves as a ground to protect itself from its own high-voltage power."),
            Pokemon(135, "Jolteon", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/135.png", "Electric", "It accumulates negative ions in the atmosphere to blast out 10,000-volt lightning bolts."),

            // Psychic/Legendary
            Pokemon(150, "Mewtwo", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/150.png", "Psychic", "It was created by a scientist after years of horrific gene splicing and DNA engineering experiments."),
            Pokemon(151, "Mew", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/151.png", "Psychic", "So rare that it is still said to be a mirage by many experts. Only a few people have seen it worldwide."),

            // Ghost Types
            Pokemon(92, "Gastly", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/92.png", "Ghost/Poison", "Almost invisible, this gaseous Pokémon cloaks the target and puts it to sleep without notice."),
            Pokemon(93, "Haunter", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/93.png", "Ghost/Poison", "It hides in the dark, planning to take the life of the next living thing that wanders close by."),
            Pokemon(94, "Gengar", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/94.png", "Ghost/Poison", "Hides in shadows. It is said that if Gengar is lurking, it cools the area by nearly 10 degrees."),

            // Normal Types
            Pokemon(133, "Eevee", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/133.png", "Normal", "Its genetic code is irregular. It may mutate if it is exposed to radiation from element stones."),
            Pokemon(143, "Snorlax", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/143.png", "Normal", "Its stomach can digest any kind of food, even if it happens to be a little moldy."),
            Pokemon(39, "Jigglypuff", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/39.png", "Normal/Fairy", "When its huge eyes waver, it sings a mysteriously soothing melody that lulls its enemies to sleep."),
            Pokemon(40, "Wigglytuff", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/40.png", "Normal/Fairy", "Its body is very elastic. By inhaling deeply, it can continue to inflate itself without limit."),

            // Dragon Types
            Pokemon(147, "Dratini", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/147.png", "Dragon", "It sheds many layers of skin as it grows larger. During this process, it is protected by a rapid waterfall."),
            Pokemon(148, "Dragonair", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/148.png", "Dragon", "It is called the divine Pokémon. When its entire body lightens slightly, the weather changes."),
            Pokemon(149, "Dragonite", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/149.png", "Dragon/Flying", "An extremely rarely seen marine Pokémon. Its intelligence is said to match that of humans."),

            // Bird Pokémon
            Pokemon(16, "Pidgey", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/16.png", "Normal/Flying", "Very docile. If attacked, it will often kick up sand to protect itself rather than fight back."),
            Pokemon(17, "Pidgeotto", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/17.png", "Normal/Flying", "This Pokémon is full of vitality. It constantly flies around its large territory in search of prey."),
            Pokemon(18, "Pidgeot", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/18.png", "Normal/Flying", "When hunting, it skims the surface of water at high speed to pick off unwary prey such as Magikarp."),

            // Bug Types
            Pokemon(10, "Caterpie", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/10.png", "Bug", "Its short feet are tipped with suction pads that enable it to tirelessly climb slopes and walls."),
            Pokemon(11, "Metapod", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/11.png", "Bug", "This Pokémon is vulnerable to attack while its shell is soft, exposing its weak and tender body."),
            Pokemon(12, "Butterfree", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/12.png", "Bug/Flying", "In battle, it flaps its wings at high speed to release highly toxic dust into the air."),

            // Rock/Ground Types
            Pokemon(74, "Geodude", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/74.png", "Rock/Ground", "Commonly found near mountain trails and the like. If you step on one by accident, it gets angry."),
            Pokemon(95, "Onix", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/95.png", "Rock/Ground", "As it grows, the stone portions of its body harden to become similar to a diamond, but colored black."),
            Pokemon(111, "Rhyhorn", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/111.png", "Ground/Rock", "Its massive bones are 1000 times harder than human bones. It can easily knock a trailer flying."),

            // Water Types
            Pokemon(54, "Psyduck", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/54.png", "Water", "While lulling its enemies with its vacant look, this wily Pokémon will use psychokinetic powers."),
            Pokemon(55, "Golduck", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/55.png", "Water", "Often seen swimming elegantly by lake shores. It is often mistaken for the Japanese monster, Kappa."),
            Pokemon(129, "Magikarp", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/129.png", "Water", "In the distant past, it was somewhat stronger than the horribly weak descendants that exist today."),
            Pokemon(130, "Gyarados", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/130.png", "Water/Flying", "Rarely seen in the wild. Huge and vicious, it is capable of destroying entire cities in a rage."),

            // Fire Types
            Pokemon(37, "Vulpix", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/37.png", "Fire", "At the time of its birth, it has just one white tail. The tail splits from its tip as it grows older."),
            Pokemon(38, "Ninetales", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/38.png", "Fire", "Very smart and very vengeful. Grabbing one of its many tails could result in a 1000-year curse."),
            Pokemon(58, "Growlithe", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/58.png", "Fire", "Very protective of its territory. It will bark and bite to repel intruders from its space."),
            Pokemon(59, "Arcanine", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/59.png", "Fire", "A Pokémon that has been admired since the past for its beauty. It runs agilely as if on wings."),

            // Grass Types
            Pokemon(43, "Oddish", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/43.png", "Grass/Poison", "During the day, it keeps its face buried in the ground. At night, it wanders around sowing its seeds."),
            Pokemon(44, "Gloom", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/44.png", "Grass/Poison", "The fluid that oozes from its mouth isn't drool. It is a nectar that is used to attract prey."),
            Pokemon(45, "Vileplume", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/45.png", "Grass/Poison", "The larger its petals, the more toxic pollen it contains. Its big head is heavy and hard to hold up."),

            // Fighting Types
            Pokemon(56, "Mankey", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/56.png", "Fighting", "Extremely quick to anger. It could be docile one moment then thrashing away the next instant."),
            Pokemon(57, "Primeape", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/57.png", "Fighting", "It becomes wildly furious if it even senses someone looking at it. It chases anyone that meets its glare."),
            Pokemon(66, "Machop", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/66.png", "Fighting", "Loves to build its muscles. It trains in all styles of martial arts to become even stronger."),

            // Poison Types
            Pokemon(29, "Nidoran♀", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/29.png", "Poison", "Although small, its venomous barbs render this Pokémon dangerous. The female has smaller horns."),
            Pokemon(32, "Nidoran♂", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/32.png", "Poison", "It stiffens its ears to sense danger. The larger its horns, the more powerful its secreted venom."),
            Pokemon(33, "Nidorino", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/33.png", "Poison", "An aggressive Pokémon that is quick to attack. The horn on its head secretes a powerful venom."),

            // Fairy Types (retroactivos)
            Pokemon(35, "Clefairy", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/35.png", "Fairy", "Its magical and cute appeal has many admirers. It is rare and found only in certain areas."),
            Pokemon(36, "Clefable", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/36.png", "Fairy", "A timid fairy Pokémon that is rarely seen. It will run and hide the moment it senses people.")

        )
        _pokemonList.value = list
    }

    fun selectPokemon(pokemon: Pokemon) {
        _selectedPokemon.value = pokemon
    }
}