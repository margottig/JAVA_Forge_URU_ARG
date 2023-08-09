package com.marcelo.tienda.clases;

public class Item {
	
	// Variables miembro
	public String nombre; // valor default undefined/null
	private double precio; // 0.0
	
	
	//CONSTRUCTOR
	public Item() {};  // Constructor default
	// Constructor sobrecargado
	public Item(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;	
	}

	// GETTERS & SETTER
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	

	
	
}
