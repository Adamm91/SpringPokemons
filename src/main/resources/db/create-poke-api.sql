--DROP TABLE poke IF EXISTS;

CREATE TABLE pokemons (
ID INTEGER PRIMARY KEY,
name VARCHAR (30),
weight VARCHAR (30),
speciecUrl VARCHAR (100),
speciecName VARCHAR (30),
abilities VARCHAR (200),
statsDto VARCHAR (200)
);