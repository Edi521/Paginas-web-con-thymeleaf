package com.mx.Mochila.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Mochila.Dominio.Mochila;
import com.mx.Mochila.Repository.IMochilaRepository;

@Service
public class MochilaServiceImp implements IMochilaService{
	
	@Autowired
	private IMochilaRepository dao;

	@Override
	public void guardar(Mochila mochila) {
		// TODO Auto-generated method stub
		dao.save(mochila);
	}

	@Override
	public void editar(Mochila mochila) {
		// TODO Auto-generated method stub
		dao.save(mochila);
	}

	@Override
	public void eliminar(Mochila mochila) {
		// TODO Auto-generated method stub
		dao.delete(mochila);
	}

	@Override
	public Mochila buscar(Mochila mochila) {
		// TODO Auto-generated method stub
		return dao.findById(mochila.getIdMochila()).orElse(null);
	}

	@Override
	public List<Mochila> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC,"idMochila"));
	}

	
	public List<Mochila> byMarca(String marca){
		return dao.findByMarcaIgnoringCaseContaining(marca);
	}
}
