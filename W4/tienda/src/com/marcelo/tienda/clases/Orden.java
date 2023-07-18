package com.marcelo.tienda.clases;

import java.util.ArrayList;

public class Orden {
	
	//Variables miembro
	private String nombre; //valor default undefined/null
	private double total;  // valor default 0.0
	private boolean listo;  // valor default false
	private ArrayList<Item> items; //default es null
	
	
	// CONSTRUCTOR
	public Orden() {
		this.nombre = "No Identificado";
		this.items = new ArrayList<Item>();
		
	}
	
	// SOBRECARGA DE CONSTRUCTOR
	public Orden(String nombre) {
		this.nombre = nombre;
	}
	
	//METODOS PROPIOS
	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	public void desplegarInfo() {
		// debemos iterar sobre el arraylist
		//System.out.printf("Nombre: %s\n", orden1.nombre);
//		System.out.printf("Total: %s\n", orden1.total);
//		System.out.printf("Listo: %s\n", orden1.listo);
	}
	
	
	// GETTER Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isListo() {
		return listo;
	}

	public void setListo(boolean listo) {
		this.listo = listo;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	
	
	
	

}
