package com.pokemon.rest;


import com.pokemon.dto.PokemonDto;
import com.pokemon.service.PokemonJdbcService;
import com.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class PokemonRest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private PokemonService pokemonService;

    @Autowired
    private PokemonJdbcService pokemonJdbcService;


    @Autowired
    public PokemonRest(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @RequestMapping("/pokemon")
    public PokemonDto getPokemon(@RequestParam(value = "id") String id) throws IOException {


        return new PokemonDto();
    }

    @RequestMapping("/getpokemons")
    public List<Map<String, Object>> getPokemons() {
        List<Map<String, Object>> pokemonsFromDatabase = this.pokemonJdbcService.getPokemonsFromDatabase();
        return pokemonsFromDatabase;
    }


    @PostMapping("/addPokemon")
    public ResponseEntity<String> addPokemon(@RequestBody PokemonDto pokemonDto) {
        this.pokemonJdbcService.addToPokemonTable(pokemonDto);
        return ResponseEntity.ok("ok");
    }


//
//    @RequestMapping("/showAll")
//    public List<PokemonDto> showPokemon() {
//        return pokemonDtosList;
//    }


}
