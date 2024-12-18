package com.mx.Pokedex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Pokedex.Dao.IPokedexDao;
import com.mx.Pokedex.Dominio.Pokemon;

@Service

public class PokemonServiceImp implements IPokedexService{

	@Autowired
	private IPokedexDao dao;
	
	@Override
	public void guardar(Pokemon pok) {
		// TODO Auto-generated method stub
		dao.save(pok);
	}

	@Override
	public void editar(Pokemon pok) {
		// TODO Auto-generated method stub
		dao.save(pok);
	}

	@Override
	public void eliminar(Pokemon pok) {
		// TODO Auto-generated method stub
		dao.delete(pok);
	}

	@Override
	public Pokemon buscar(Pokemon pok) {
		// TODO Auto-generated method stub
		return dao.findById(pok.getIdPokemon()).orElse(null);
	}

	@Override
	public List<Pokemon> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC,"idPokemon"));
	}
	
	public List<Pokemon> byTipo(String tipo){
		return dao.findByTipoIgnoringCaseContaining(tipo);
	}
	
	public Pokemon byNombre(String nombre) {
		return dao.findByNombreIgnoringCaseContaining(nombre);
	}

}
