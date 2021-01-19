package net.royal.spring.framework.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.royal.spring.framework.core.dominio.chartsjs.Chartjs;
import net.royal.spring.framework.core.dominio.chartsjs.ChartjsData;

public class ChartjsTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Chartjs> lst = new ArrayList<Chartjs>();
		
		List<String> indicador9Columnas=new ArrayList<>();
		indicador9Columnas.add("Región");
		indicador9Columnas.add("N° Integrantes");
		List<ChartjsData> indicador9Datos=new ArrayList<>();
		indicador9Datos.add(new ChartjsData("Cajamarca",new BigDecimal(5)));
		indicador9Datos.add(new ChartjsData("Amazonas",new BigDecimal(6)));
		indicador9Datos.add(new ChartjsData("San Martín",new BigDecimal(7)));		
		Chartjs c1=new Chartjs("bar",indicador9Columnas,indicador9Datos);
		c1.setTitulo("Integrantes X Región");
		c1.generar();
		
		List<String> indicador2Columnas=new ArrayList<>();
		indicador2Columnas.add("Profesión");
		indicador2Columnas.add("N° Integrantes");
		List<ChartjsData> indicador2Datos=new ArrayList<>();
		indicador2Datos.add(new ChartjsData("Ingeniero",new BigDecimal(5)));
		indicador2Datos.add(new ChartjsData("Agronomo",new BigDecimal(6)));
		indicador2Datos.add(new ChartjsData("Biologo",new BigDecimal(7)));	
		Chartjs c2=new Chartjs("doughnut",indicador2Columnas,indicador2Datos);
		c1.setTitulo("Integrantes X Profesión");
		c2.generar();
		
		List<String> indicador3Columnas=new ArrayList<>();
		indicador3Columnas.add("Tipo de Institución");
		indicador3Columnas.add("N° Integrantes");
		List<ChartjsData> indicador3Datos=new ArrayList<>();
		indicador3Datos.add(new ChartjsData("Público",new BigDecimal(42)));
		indicador3Datos.add(new ChartjsData("Privado",new BigDecimal(35)));
		Chartjs c3=new Chartjs("pie",indicador3Columnas,indicador3Datos);
		c3.setTitulo("Integrantes X Tipo de Institución");
		c3.generar();
		
		
		List<String> indicador1Columnas=new ArrayList<>();
		indicador1Columnas.add("Institución");
		indicador1Columnas.add("N° Integrantes");
		List<ChartjsData> indicador1Datos=new ArrayList<>();
		indicador1Datos.add(new ChartjsData("SENASA",new BigDecimal(11)));
		indicador1Datos.add(new ChartjsData("INIA",new BigDecimal(10)));
		indicador1Datos.add(new ChartjsData("PRO",new BigDecimal(12)));
		Chartjs c4=new Chartjs("line",indicador1Columnas,indicador1Datos);
		c4.setTitulo("Integrantes X Institución");
		c4.generar();
		
		lst.add(c1);
		lst.add(c2);
		lst.add(c3);
		lst.add(c4);
		
		System.out.println("columnas");
	}

}
