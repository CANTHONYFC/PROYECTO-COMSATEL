package net.royal.spring.framework.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.spring.framework.core.dominio.DominioArchivo;

public class UListXmlTest {
	static String[] arrColumnas = new String[] { "id", "nombre", "edad", "sueldo", "fechaNacimiento" };

	public static void main(String[] args) throws Exception {
		byte[] file = null;
		String ruta="";
		List lstDatos = obtenerData();
		DominioArchivo dto = null;
		
		System.out.println("==>ASIGNAR CARPETA TEMPORAL");
		UList.rutaTemporal = "D:\\TEMPORAL";
		System.out.println(UList.rutaTemporal);
					
		System.out.println("==>XML");
		file = UList.listToXmlByte(lstDatos);		
		System.out.println(new String(file));
		
		System.out.println("==>XML");
		dto = UList.listToXml(lstDatos);		
		System.out.println(dto.getRutaCompleta());
		System.out.println(dto.getMimeType());
		System.out.println(dto.getNombre());
				
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
