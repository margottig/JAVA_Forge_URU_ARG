package com.cd.mobiles.objetos;

import com.cd.mobiles.telefono.Telefono;

public class Galaxy extends Telefono {
	
	//NO TIENE VARIABLES MIEMBRO

	//constructor, usa atributos de super class Telefono
	public Galaxy(String numeroSerie, int porcentajeBateria, String ringTone) {
		super(numeroSerie, porcentajeBateria, ringTone);
		
	}
	
	public void desplegarInfo() {
		
		// metodo clase maestra
		super.desplegarInfo();
		System.out.println("Numero Serie: " + this.getNumeroSerie()+  " " + "RingTone: " + this.getRingTone());
	}
	
	
	
	
	
	
	
	

}
