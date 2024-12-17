package com.mx.Pokedex.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data


public class Pokemon {
	
	
	@Id
	private int idPokemon;
	
	private String nombre;
	private String tipo;
	private int salud;
	private String descripcion;
	

}
