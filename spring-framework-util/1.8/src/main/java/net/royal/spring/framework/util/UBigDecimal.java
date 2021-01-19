package net.royal.spring.framework.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class UBigDecimal {
	public static BigDecimal VALOR_TEMPORAL = new BigDecimal(-1);
	
	public static BigDecimal obtenerValorSinNulo(BigDecimal numero) {
		if (numero == null) {
			return new BigDecimal(0);
		}
		
		return numero;
	}
	public static boolean esNulo(BigDecimal numero) {
		if (numero == null) {
			return true;
		}		
		return false;
	}
	public static boolean esCeroOrNulo(BigDecimal numero) {
		if (numero == null) {
			return true;
		}
		if (numero.compareTo(BigDecimal.ZERO)==0) {
			return true;
		}
		return false;
	}

	public static BigDecimal restar(BigDecimal sumando1, BigDecimal sumando2) {
		if (sumando1 == null)
			sumando1 = BigDecimal.ZERO;
		if (sumando2 == null)
			sumando2 = BigDecimal.ZERO;
		return sumando1.subtract(sumando2);
	}

	public static BigDecimal restar(BigDecimal sumando1, BigDecimal sumando2, Integer scale) {
		if (sumando1 == null)
			sumando1 = BigDecimal.ZERO;
		if (sumando2 == null)
			sumando2 = BigDecimal.ZERO;
		if (scale == null)
			return sumando1.subtract(sumando2);
		else
			return sumando1.subtract(sumando2).setScale(scale);
	}

	public static BigDecimal sumar(BigDecimal sumando1, BigDecimal sumando2) {
		if (sumando1 == null)
			sumando1 = BigDecimal.ZERO;
		if (sumando2 == null)
			sumando2 = BigDecimal.ZERO;
		return sumando1.add(sumando2);
	}

	public static BigDecimal sumar(BigDecimal sumando1, BigDecimal sumando2, Integer scale) {
		if (sumando1 == null)
			sumando1 = BigDecimal.ZERO;
		if (sumando2 == null)
			sumando2 = BigDecimal.ZERO;
		if (scale == null)
			return sumando1.add(sumando2);
		else
			return sumando1.add(sumando2).setScale(scale);
	}

	public static BigDecimal multiplicar(BigDecimal elemento1, BigDecimal elemento2, Integer scale) {
		if (elemento1 == null)
			elemento1 = BigDecimal.ZERO;
		if (elemento2 == null)
			elemento2 = BigDecimal.ZERO;
		
		MathContext mc = new MathContext(scale, RoundingMode.HALF_EVEN);
		try {
			
			
			BigDecimal xx = elemento1.multiply(elemento2, mc).setScale(scale, RoundingMode.HALF_EVEN);
			return xx;
		} catch (Exception e) {
		}
		return elemento1.multiply(elemento2, mc).setScale(scale, RoundingMode.HALF_EVEN);
	}

	public static BigDecimal dividir(BigDecimal elemento1, BigDecimal elemento2, Integer scale) {
		MathContext mc = new MathContext(9, RoundingMode.HALF_EVEN);
		if (elemento1 == null)
			elemento1 = BigDecimal.ZERO;
		if (elemento2 == null)
			elemento2 = BigDecimal.ZERO;
		if (elemento2 == BigDecimal.ZERO)
			return BigDecimal.ZERO;
		return elemento1.divide(elemento2,  mc)
				.setScale(scale, RoundingMode.HALF_EVEN);
	}
	
	public static Boolean esMayorIgualque(BigDecimal valor1, BigDecimal valor2) {
		Integer valor = valor1.compareTo(valor2);
		if (valor == 0 || valor == 1) {
			return true;
		}
		return false;
	}
	
	public static Boolean esMayorQue(BigDecimal valor1, BigDecimal valor2) {
		Integer valor = valor1.compareTo(valor2);
		if (valor == 1) {
			return true;
		}
		return false;
	}
	
	public static Boolean esMenorQue(BigDecimal valor1, BigDecimal valor2) {
		Integer valor = valor1.compareTo(valor2);
		if ( valor == -1) {
			return true;
		}
		return false;
	}
	

	public static Boolean esMenorIgualque(BigDecimal valor1, BigDecimal valor2) {
		Integer valor = valor1.compareTo(valor2);
		if (valor == 0 || valor == -1) {
			return true;
		}
		return false;
	}

	public static Boolean esDiferente(BigDecimal valor1, BigDecimal valor2) {
		Integer valor = valor1.compareTo(valor2);
		if (valor == 1 || valor == -1) {
			return true;
		}
		return false;
	}
}
