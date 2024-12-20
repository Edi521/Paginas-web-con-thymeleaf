package com.mx.Mochila.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Mochila.Dominio.Mochila;
import com.mx.Mochila.Service.MochilaServiceImp;

@RestController
@RequestMapping(path = "/mochila")
@CrossOrigin


public class MochilaWS {
	
	@Autowired
	private MochilaServiceImp ser;
	
	//URL: http://localhost:8020/mochila
	
	//Listar-------------------------------------------------------> http://localhost:8020/mochila/lista
	@GetMapping("/lista")
	public ResponseEntity<?> listar(){
		List<Mochila> mochilas = ser.listar();
		if(mochilas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(mochilas);
		}
	}
	
	//Guardar------------------------------------------------------------------> http://localhost:8020/mochila/guardar
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@RequestBody Mochila mochila){
		if(ser.buscar(mochila) == null) {
			ser.guardar(mochila);
			return ResponseEntity.status(HttpStatus.CREATED).body("{\"Mensaje\":\"Se ha almacenado la mochila marca: "+mochila.getMarca()+" con exito.\"}");
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"Mensaje\":\"La mochila marca: "+mochila.getMarca()+ " no se pudo almacenar. ID existente\"}");
		}
	}
	
	
	//Editar---------------------------------------------------------> http://localhost:8020/mochila/editar
	@PutMapping("/editar")
	public ResponseEntity<?> editar(@RequestBody Mochila mochila){
		if(ser.buscar(mochila) != null) {
			ser.editar(mochila);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"Se ha editado la mochila "+mochila.getIdMochila()+" con exito.\"}");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//Eliminar---------------------------------------------------------------> http://localhost:8020/mochila/eliminar
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Mochila mochila){
		ser.eliminar(mochila);
		return ResponseEntity.noContent().build();
	}
	
	//Buscar---------------------------------------------------------------> http://localhost:8020/mochila/buscar
	@PostMapping("/buscar")
	public ResponseEntity<?> buscar(@RequestBody Mochila mochila){
		Mochila encontrada = ser.buscar(mochila);
		if(encontrada != null) {
			return ResponseEntity.ok(encontrada);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Por marca---------------------------------------------------------------> http://localhost:8020/mochila/buscarMarca
	@GetMapping("/buscarMarca")
	public ResponseEntity<?> porMarca(@RequestParam String marca){
		List<Mochila> mochilas = ser.byMarca(marca);
		if(mochilas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(mochilas);
		}
	}

}
