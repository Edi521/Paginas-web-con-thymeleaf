package com.mx.Pokedex.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.Pokedex.Dominio.Pokemon;
import com.mx.Pokedex.Service.PokemonServiceImp;

@Controller
@RequestMapping(path = "/")


public class PokedexController {
	
	@Autowired
	private PokemonServiceImp ser;
	
	//Listar
	@GetMapping
	public String index(Model model) {
		var lista = ser.listar();
		model.addAttribute("lista",lista);
		return "index";
	}
	
	//dirigir al html de registro
	@GetMapping(path = "/registro")
	public String registro(Pokemon pok, Model model) {
		model.addAttribute("pokemon",pok);
		return "registro";
	}
	
	//dirigirse al html de editra
	@GetMapping(path = "/editarFormato/{idPokemon}")
	public String formatoEditar(Pokemon pokemon, Model model) {
		pokemon = ser.buscar(pokemon);
		model.addAttribute("pokemon",pokemon);
		return "editar";
	}
	
	
	//dirigirse al html de tipo
	@GetMapping(path = "/busqueda")
	public String busquedaTipo(@RequestParam String tipo, Model model) {
		//Busqueda pot ripo
		List<Pokemon> resultados = ser.byTipo(tipo);
		// Añade los resultados al modelo para mostrarlos en la vista
		model.addAttribute("resultados", resultados);
		model.addAttribute("tipo", tipo); // Pasar el término de búsqueda a la vista
		return "tipo";
		
	}
	
	//Metodo para guardar un pokemon
	@PostMapping(path = "/guardar")
	public String guardar(Pokemon pok) {
		ser.guardar(pok);
		return "redirect:/";
	}
	
	//Metodo para editar
	@PostMapping(path = "/editar")
	public String editar(Pokemon pokemon) {
		ser.editar(pokemon);
		return "redirect:/";
	}
	
	//Metodo para eliminar
	@GetMapping(path = "/eliminar/{idPokemon}")
	public String eliminar(Pokemon pok) {
		pok = ser.buscar(pok);
		ser.eliminar(pok);
		return "redirect:/";
	}

}
