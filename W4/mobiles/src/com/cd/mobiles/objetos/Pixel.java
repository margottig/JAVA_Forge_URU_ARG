package com.cd.mobiles.objetos;

import com.cd.mobiles.interfaces.Sonido;
import com.cd.mobiles.telefono.Telefono;

public class Pixel extends Telefono implements Sonido {

	public Pixel(String numeroSerie, int porcentajeBateria, String ringTone) {
		super(numeroSerie, porcentajeBateria, ringTone);

	}
	
	
	
	//POLIMORFISMO FUERTE
		public void desplegarInfo() {
			System.out.println("Numero Modelo: "+ this.getNumeroSerie());
			System.out.println("Porcentaje Bateria: "+ this.getPorcentajeBateria());
			System.out.println("Tono llamada: "+ this.getRingTone());
		}
		
		public void metodoPrueba() {};
	
		
	//Implementar metodos desde la interfaz de Sonido
		@Override
		public String ring() {
			return this.getRingTone();
		}
		@Override
		public String desbloquear() {
			return "Desbloqueo pixel a traves de reconocimiento facial";
		}

}
