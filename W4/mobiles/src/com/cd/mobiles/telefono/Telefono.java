package com.cd.mobiles.telefono;

public abstract class Telefono {
	
	//variables miembro
	private String numeroSerie;
	private int porcentajeBateria;
	private String ringTone;
	
	//CONSTRUCTOR 
	public Telefono() {};
	// SOBRECARGA DE CONSTRUCTOR
	public Telefono(String numeroSerie, int porcentajeBateria, String ringTone) {
		this.numeroSerie = numeroSerie;
		this.porcentajeBateria = porcentajeBateria;
		this.ringTone = ringTone;
	}
	
	public abstract void desplegarInfo();
	public void desplegarInfo(String elemento) {
		System.out.println("Hola desde Telefono "+ elemento);
	}
	
	public abstract void metodoPrueba();
	
	
	// GETTERS Y SETTERS
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public int getPorcentajeBateria() {
		return porcentajeBateria;
	}
	public void setPorcentajeBateria(int porcentajeBateria) {
		this.porcentajeBateria = porcentajeBateria;
	}
	public String getRingTone() {
		return ringTone;
	}
	public void setRingTone(String ringTone) {
		this.ringTone = ringTone;
	}
	
	
	

}
