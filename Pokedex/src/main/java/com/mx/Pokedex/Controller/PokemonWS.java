package com.mx.Pokedex.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Pokedex.Dominio.Pokemon;
import com.mx.Pokedex.Service.PokemonServiceImp;

@RestController
@CrossOrigin
@RequestMapping(path = "/pokedex")


public class PokemonWS {
	
	
	
	@Autowired
	private PokemonServiceImp ser;
	
	
	//URL:------------------------------------> http://localhost:8003/pokedex
	
	
	
	//listar------------------------------------------------------------------------------>http://localhost:8003/pokedex/listar
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		List<Pokemon> pokemones = ser.listar();
		if(pokemones.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(pokemones);
		}
	}
	
	
	//guardar----------------------------------------------------------------------------> http://localhost:8003/pokedex/guardar
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@RequestBody Pokemon pok){
		if(ser.buscar(pok) == null) {
			if(ser.byNombre(pok.getNombre()) == null) {
				ser.guardar(pok);
				return ResponseEntity.status(HttpStatus.OK).body("{\"mensaje\":\"Se guardo a "+pok.getNombre()+"\"}");
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":" + pok.getNombre() + " ya esta registrado\"}");
			}
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El id "+pok.getIdPokemon()+" ya existe\"}");
		}
	}
	
	
	//editar------------------------------------------------------------------------------> http://localhost:8003/pokedex/editar
	@PutMapping("/editar")
	public ResponseEntity<?> editar(@RequestBody Pokemon pok){
		if(ser.buscar(pok) != null) {
			ser.editar(pok);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"Se ha editado el pokemon con el id "+pok.getIdPokemon()+" con exito.\"}");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//eliminar-----------------------------------------------------------------------------> http://localhost:8003/pokedex/eliminar
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Pokemon pok){
		ser.eliminar(pok);
		return ResponseEntity.noContent().build();
	}
	
	

}
