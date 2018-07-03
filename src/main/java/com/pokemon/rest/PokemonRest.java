package com.pokemon.rest;


import com.pokemon.cache.PokemonCache;
import com.pokemon.dto.PokemonDto;
import com.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@RestController
public class PokemonRest {

    private PokemonService pokemonService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PokemonCache pokemonCache;


    @Autowired
    public PokemonRest(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @RequestMapping("/pokemon")
    public PokemonDto getPokemon(@RequestParam(value="id") String id) throws IOException {


        return new PokemonDto();
    }


    @PostMapping("/addPokemon")
    public ResponseEntity<String> addPokemon(@RequestBody PokemonDto pokemonDto) {
        pokemonCache.pokemonDtosList.add(pokemonDto);

        return ResponseEntity.ok("ok");
    }


    @RequestMapping("/showAll")
    public List<PokemonDto> showPokemon() {
        List<PokemonDto> pokemonDtosList = pokemonCache.pokemonDtosList;
        return pokemonDtosList;
    }


}
