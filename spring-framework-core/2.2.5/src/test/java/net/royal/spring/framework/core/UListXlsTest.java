package net.royal.spring.framework.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.spring.framework.core.dominio.DominioArchivo;

public class UListXlsTest {
	static String[] arrColumnas = new String[] { "id", "nombre"};

	public static void main(String[] args) throws Exception {
		DominioArchivo dto = null;
		byte[] file = null;
		String ruta="";
		List lstDatos = obtenerData();
		
		System.out.println("==>ASIGNAR CARPETA TEMPORAL");
		UList.rutaTemporal = "D:\\TEMPORAL";
		System.out.println(UList.rutaTemporal);
				
		System.out.println("==>XLS 0.0");
		dto = UList.listToXls(lstDatos);		
		System.out.println(dto.getRutaCompleta());
		System.out.println(dto.getMimeType());
		System.out.println(dto.getNombre());
		
		System.out.println("==>XLS 0.1");
		dto = UList.listToXls(lstDatos,arrColumnas);		
		System.out.println(dto.getRutaCompleta());
		System.out.println(dto.getMimeType());
		System.out.println(dto.getNombre());
		
		System.out.println("==>XLS");
		ruta = UList.listToXlsFile(lstDatos);		
		System.out.println(ruta);
		System.out.println("==>XLS:BYTE[]");
		file = UList.listToXlsArchivo(lstDatos);		
		System.out.println(file);
		
		System.out.println("==>XLS-2");
		ruta = UList.listToXlsFile(lstDatos,arrColumnas);		
		System.out.println(ruta);
		System.out.println("==>XLS-2:BYTE[]");
		file = UList.listToXlsArchivo(lstDatos,arrColumnas);		
		System.out.println(file);
		
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
