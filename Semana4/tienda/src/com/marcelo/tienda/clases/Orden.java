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
		
		// una vez que agregemos un item, sumalo al total de la orden
//		this.total += item.getPrecio();
	}
	
	public void desplegarInfo() {
		System.out.println(" Nombre Cliente: " + this.nombre);
		for(Item item : this.items ) {
			System.out.println(item.getNombre() + " "+ item.getPrecio());
		}
		System.out.println("Total compra: " + getTotalOrden() );
//		System.out.println("Total compra: " + getTotal() );
	}
	
	
	public double getTotalOrden() {
		double total = 0;
		for(Item item : this.items) {
			total += item.getPrecio();
			}
		return total;
	}
	
	public String getStatusOrden() {
		if(this.listo) {
			return "Tu orden esta lista";
		}
		return "Gracias por tu espera, tu orden estara lista en unos minutos";
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

	public void setListo(boolean listo ) {
		this.listo = listo;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	
	
	
	

}
