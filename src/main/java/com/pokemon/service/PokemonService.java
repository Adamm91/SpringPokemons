package com.pokemon.service;

import com.pokemon.dto.PokemonDto;

import java.io.IOException;

public interface PokemonService {

    public PokemonDto getPokemonDto(String id) throws IOException;
}
