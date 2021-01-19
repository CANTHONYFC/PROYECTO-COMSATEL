package net.royal.spring.framework.util;

import java.text.DecimalFormat;

public class UDouble {
	public static String obtenerValorCadena(double numero) {
		DecimalFormat df = new DecimalFormat("#.##");
		String formatted = df.format(numero); 
		
		return formatted;
	}
}
