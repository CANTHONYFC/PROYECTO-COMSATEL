package net.royal.spring.framework.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UListTest {
	static String[] arrColumnas = new String[] { "id", "nombre", "edad", "sueldo", "fechaNacimiento" };

	public static void main(String[] args) throws Exception {
		byte[] file = null;
		String ruta="";
		List lstDatos = obtenerData();
		
		System.out.println("==>ASIGNAR CARPETA TEMPORAL");
		UList.rutaTemporal = "D:\\TEMPORAL";
		System.out.println(UList.rutaTemporal);
					
		System.out.println("==>XML");
		file = UList.listToXmlByte(lstDatos);		
		System.out.println(new String(file));
				
		System.out.println("==>CSV:NO SE ORDENA CORRECTAMENTE");
		ruta = UList.listToCsvFile(lstDatos);	
		System.out.println(ruta);
		
		System.out.println("==>CSV:NO SE ORDENA CORRECTAMENTE|BYTE");
		file = UList.listToCsvByte(lstDatos);	
		System.out.println(file);
		
		System.out.println("==>CSV");
		file = UList.listToCsvByte(lstDatos,MiClase.class,arrColumnas);	
		System.out.println(new String(file));
				
		System.out.println("==>TXT:NO SE ORDENA CORRECTAMENTE");
		ruta = UList.listToTxtFile(lstDatos);	
		System.out.println(ruta);
		
		System.out.println("==>TXT:NO SE ORDENA CORRECTAMENTE|BYTE");
		file = UList.listToTxtByte(lstDatos);	
		System.out.println(file);
		
		System.out.println("==>TXT");
		file = UList.listToTxt(lstDatos,MiClase.class,arrColumnas);	
		System.out.println(new String(file));
	}

	public static List obtenerData() {
		MiClase e = null;
		List lst = new ArrayList<>();
		e = new MiClase();
		e.setId("1");
		e.setDni("98378732");
		e.setNombre("dario");
		lst.add(e);
		///////////////////
		e = new MiClase();
		e.setId("2");
		e.setDni("000987");
		e.setNombre("jose");
		e.setEdad(25);
		e.setSueldo(new BigDecimal(80000));
		e.setFechaNacimiento(new Date());
		lst.add(e);
		///////////////////
		e = new MiClase();
		e.setId("3");
		e.setDni("2223333");
		e.setNombre("maria jose");
		e.setEdad(19);
		e.setSueldo(new BigDecimal(800));
		e.setFechaNacimiento(new Date());
		lst.add(e);

		return lst;
	}

}
