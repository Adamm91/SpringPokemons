//package com.pokemon.unit;
//
//import com.pokemon.service.PokemonService;
//import com.pokemon.service.PokemonServiceImplTest;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.io.IOException;
//
//public class PokemonServiceTest {
//
//
//    PokemonService pokemonService = new PokemonServiceImplTest();
//
//    @Test
//    public void shouldReturnBulbasaur() throws IOException {
//        Assert.assertEquals(pokemonService
//                .getPokemonDto("test").getName(),"bublbasaur");
//    }
//
//    @Test
//    public void shoudlNotReturnBulbasaur() throws IOException {
//        Assert.assertNotEquals(pokemonService
//                .getPokemonDto("test").getName(),"bu");
//
//    }
//}
