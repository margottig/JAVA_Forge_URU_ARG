package com.marcelo.tienda.clases;

import java.util.ArrayList;

public class Orden {
	
	//Variables miembro
	public String nombre; //valor default undefined/null
	public double total;  // valor default 0.0
	public boolean listo;  // valor default false
	public ArrayList<Item> items = new ArrayList<Item>();
	

}
