package com.marcelo.tienda.main;

import com.marcelo.tienda.clases.Item;
import com.marcelo.tienda.clases.Orden;

public class TestOrden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(" Proyecto Tienda");
		
	
		// PRODUCTOS
		Item producto1 = new Item();
		producto1.nombre = "mate";
		producto1.precio = 3.25;
		
		// ORDENES DE PRODUCTO
		Orden orden1 = new Orden();
		orden1.nombre = "Sonic";
		
		//Aplicar el producto1 a la orden1
		orden1.items.add(producto1);
		orden1.total = orden1.total + producto1.precio;
		orden1.listo = true;
		
		//TEST INFORMACION DE PRODUCTOS Y ORDEN DE PRODUCTOS
		System.out.printf("Nombre: %s\n", orden1.nombre);
		System.out.printf("Total: %s\n", orden1.total);
		System.out.printf("Listo: %s\n", orden1.listo);
		
		
		
		
		
		
		
		
		
//		System.out.println(producto1.nombre);

	}

}
