package com.mx.Mochila.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Mochila {
	
	@Id
	private int idMochila;
	private String marca;
	private String color;
	private String modelo;
	private double precio;
	private int stock;
	
	

}
