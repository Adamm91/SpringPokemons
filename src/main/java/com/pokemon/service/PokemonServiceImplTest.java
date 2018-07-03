package com.pokemon.service;

import com.pokemon.dto.PokemonDto;

import java.io.IOException;

public class PokemonServiceImplTest implements PokemonService {

    @Override
    public PokemonDto getPokemonDto(String id) throws IOException {
        return new PokemonDto("bublbasaur","20");
    }
}
