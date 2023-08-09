package com.cd.mobiles.main;

import com.cd.mobiles.objetos.Galaxy;
import com.cd.mobiles.objetos.Pixel;

public class TelefonoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Galaxy s7 = new Galaxy("S7", 85, "Ring rang");
		s7.desplegarInfo();
		System.out.println("\n"+" Llamando "+ s7.ring());
		System.out.println("\n"+ s7.desbloquear());
		
		
		System.out.println("\n" + "------------- A CONTINUACION DATOS PIXEL -----------------------");
		
		
		Pixel pixelOcho = new Pixel("Pixel8", 55, "lara larala");
		pixelOcho.desplegarInfo();
		System.out.println("\n"+" Llamando "+ pixelOcho.ring());
		System.out.println("\n"+ pixelOcho.desbloquear());
		

	}

}
