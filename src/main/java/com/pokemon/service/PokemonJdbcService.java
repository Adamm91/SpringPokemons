package com.pokemon.service;

import com.pokemon.dto.PokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PokemonJdbcService {

    public List<PokemonDto> pokemonDtosList;
    long id = 0L;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void methodInit() {
        pokemonDtosList = new ArrayList<>();

    }

    public void addToPokemonTable(PokemonDto pokemonDto) {

        this.jdbcTemplate.update("insert into pokemons values (?, ?, ?, ?, ?, ?, ?)",
                ++id,
                pokemonDto.getName(),
                pokemonDto.getWeight(),
                pokemonDto.getSpeciesUrl(),
                pokemonDto.getSpeciesName(),
                pokemonDto.getAbilities().toString(),
                pokemonDto.getStatsDto().toString());
    }

    public List<Map<String, Object>> getPokemonsFromDatabase () {
        List<Map<String, Object>> pokemonDtos = this.jdbcTemplate.queryForList("select * from pokemons");
        return pokemonDtos;
    }
}


//SIMPLE EXECUTE
//// jdbcTemplate.execute("create table user (id int, name varchar)");

//SIMPLE UPDATE
//    public int addEmplyee(int id) {
//        return jdbcTemplate.update(
//                "INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?)", 5, "Bill", "Gates", "USA");
//    }


//MAP PARAMETERS
//
//    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);
//return namedParameterJdbcTemplate.queryForObject(
//        "SELECT FIRST_NAME FROM EMPLOYEE WHERE ID = :id", namedParameters, String.class);


// ROWMAPPER
//    public class EmployeeRowMapper implements RowMapper<Employee> {
////        @Override
////        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
////            Employee employee = new Employee();
////
////            employee.setId(rs.getInt("ID"));
////            employee.setFirstName(rs.getString("FIRST_NAME"));
////            employee.setLastName(rs.getString("LAST_NAME"));
////            employee.setAddress(rs.getString("ADDRESS"));
////
////            return employee;
////        }
////    }
//String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";
//    List<Employee> employees = jdbcTemplate.queryForObject(
//            query, new Object[] { id }, new EmployeeRowMapper());


//https://docs.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/data-access.html#jdbc
