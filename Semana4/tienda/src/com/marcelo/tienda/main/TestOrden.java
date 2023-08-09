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
		producto1.setPrecio(3.25);
		
		Item producto2 = new Item("cafe", 2.25);
//		System.out.println(producto2.nombre + " ESTO ES PRODUCTO 2 ");
		
		// ORDENES DE PRODUCTO
		Orden orden1 = new Orden();
		orden1.setNombre("Sonic");
		
		//Aplicar el producto1 a la orden1
		orden1.agregarItem(producto1);
		System.out.println(orden1.getTotal());
		orden1.desplegarInfo();
		String mensajeOrden = orden1.getStatusOrden();	
		System.out.println(mensajeOrden);
		orden1.setListo(true);
		System.out.println(orden1.getStatusOrden());
		
		
		
//		orden1.total = orden1.total + producto1.getPrecio();
		orden1.setTotal(producto1.getPrecio());
//		orden1.listo = true;
		
		
		
		//TEST INFORMACION DE PRODUCTOS Y ORDEN DE PRODUCTOS
//		System.out.printf("Nombre: %s\n", orden1.nombre);
//		System.out.printf("Total: %s\n", orden1.total);
//		System.out.printf("Listo: %s\n", orden1.listo);
//		
		
		
		
		
		
		
		
		
		
		
//		System.out.println(producto1.nombre);

	}

}
