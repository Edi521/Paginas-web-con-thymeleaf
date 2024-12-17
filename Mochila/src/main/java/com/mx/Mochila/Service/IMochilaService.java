package com.mx.Mochila.Service;

import java.util.List;

import com.mx.Mochila.Dominio.Mochila;

public interface IMochilaService {
	
	public void guardar(Mochila mochila);
	
	public void editar(Mochila mochila);
	
	public void eliminar(Mochila mochila);
	
	public Mochila buscar(Mochila mochila);
	
	public List<Mochila> listar();

}
