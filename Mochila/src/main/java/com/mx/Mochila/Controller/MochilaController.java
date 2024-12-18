package com.mx.Mochila.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.Mochila.Dominio.Mochila;
import com.mx.Mochila.Service.MochilaServiceImp;

@Controller
@RequestMapping(path = "/")

public class MochilaController {

	@Autowired
	private MochilaServiceImp ser;
	
	//Listar
	@GetMapping
	public String index(Model model) {
		var lista = ser.listar();
		model.addAttribute("lista",lista);
		return "index";
	}
	
	//Dirigir al html de guardar
	@GetMapping(path = "/nuevo")
	public String nuevo(Mochila mochila, Model model) {
		model.addAttribute("mochila",mochila);
		return "guardar";
	}
	
	//Dirigir al html de editar
	@GetMapping(path = "/abrirEditar/{idMochila}")
	public String abrirEditar(Mochila mochila, Model model) {
		mochila = ser.buscar(mochila);
		model.addAttribute("mochila",mochila);
		return "editar";
	}
	
	//Dirigir al Html de eliminar
	@GetMapping(path = "/abrirEliminar/{idMochila}")
	public String abrirEliminar(Mochila mochila, Model model) {
		mochila = ser.buscar(mochila);
		model.addAttribute("mochila",mochila);
		return "eliminar";
	}
	
	//Metodo para guardar una mochila
	@PostMapping(path = "/guardar")
	public String guardar(Mochila mochila) {
		ser.guardar(mochila);
		return "redirect:/";
	}
	
	//Metodo para editar un registro
	@PostMapping(path = "/editar")
	public String editar(Mochila mochila) {
		ser.editar(mochila);
		return "redirect:/";
	}
	
	//Metodo para eliminar
	@PostMapping(path = "/eliminar")
	public String eliminar(Mochila mochila) {
		ser.eliminar(mochila);
		return "redirect:/";
	}
	
	//Metodo para buscar por marca
	@PostMapping(path = "/buscarPorMarca")
	public String buscarPorMarca(@RequestParam String marca, Model model) {
		if(marca == null) {
			model.addAttribute("lista",ser.listar());
			return "index";
		}
		
		List<Mochila> mochilas = ser.byMarca(marca);
		if(mochilas.isEmpty()) {
			model.addAttribute("mensaje","No existen mochilas con la marca: "+marca);
		}else {
			model.addAttribute("mochilas",mochilas);
		}
		return "index";
			
	}
	
	
	
	
	
	
	
}
