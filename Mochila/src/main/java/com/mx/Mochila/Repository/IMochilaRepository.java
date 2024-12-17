package com.mx.Mochila.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Mochila.Dominio.Mochila;

public interface IMochilaRepository extends JpaRepository<Mochila, Integer>{
	
	public List<Mochila> findByMarcaIgnoringCaseContaining(String marca);

}
