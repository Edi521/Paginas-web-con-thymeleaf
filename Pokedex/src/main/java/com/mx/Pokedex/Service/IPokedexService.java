package com.mx.Pokedex.Service;

import java.util.List;

import com.mx.Pokedex.Dominio.Pokemon;

public interface IPokedexService {
	
	public void guardar(Pokemon pok);
	
	public void editar(Pokemon pok);
	
	public void eliminar(Pokemon pok);
	
	public Pokemon buscar(Pokemon pok);
	
	public List<Pokemon> listar();

}
