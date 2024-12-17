package com.mx.Pokedex.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Pokedex.Dominio.Pokemon;

public interface IPokedexDao extends JpaRepository<Pokemon, Integer>{
	
	
	public List<Pokemon> findByTipoIgnoringCaseContaining(String tipo);
	
	public Pokemon findByNombreIgnoringCaseContaining(String nombre);

}
