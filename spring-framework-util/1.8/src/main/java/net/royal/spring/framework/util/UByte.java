package net.royal.spring.framework.util;

public class UByte {
	public static String convertirString(byte[] arreglo) {
		if (arreglo == null)
			return null;
		return new String(arreglo);
	}
}
