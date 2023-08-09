package com.cd.mobiles.objetos;

import com.cd.mobiles.interfaces.Sonido;
import com.cd.mobiles.telefono.Telefono;

public class Galaxy extends Telefono implements Sonido{
	
	//NO TIENE VARIABLES MIEMBRO

	//constructor, usa atributos de super class Telefono
	public Galaxy(String numeroSerie, int porcentajeBateria, String ringTone) {
		super(numeroSerie, porcentajeBateria, ringTone);
		
	}
	
	//POLIMORFISMO FUERTE
	public void desplegarInfo() {
		//metodo clase maestra
		super.desplegarInfo("SALUDOS");
		System.out.println("Modelo: " + this.getNumeroSerie() + " "+"Porcentaje Bateria: "+ this.getPorcentajeBateria());
	}
	
	public void metodoPrueba() {};
	
	
	//Implementar metodos desde la interfaz de Sonido
	@Override
	public String ring() {
		return this.getRingTone();
	}
	@Override
	public String desbloquear() {
		return "Desbloqueo galaxy a traves de huella dactilar";
	}
	
	
	
	
	
}
