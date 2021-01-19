package net.royal.spring.framework.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.royal.spring.framework.core.dominio.chartsjs.Chartjs;
import net.royal.spring.framework.core.dominio.chartsjs.ChartjsData;

public class ChartjsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Chartjs> lst = new ArrayList<Chartjs>();
		
		List<String> columnas=new ArrayList<>();
		columnas.add("Meses");
		columnas.add("Lista 1");
		//columnas.add("Lista 2");
		
		List<ChartjsData> lstDatos=new ArrayList<>();
		lstDatos.add(new ChartjsData("Enero",new BigDecimal(65),new BigDecimal(28)));
		lstDatos.add(new ChartjsData("Febrero",new BigDecimal(59),new BigDecimal(48)));
		lstDatos.add(new ChartjsData("Marzo",new BigDecimal(80),new BigDecimal(40)));
		lstDatos.add(new ChartjsData("Abril",new BigDecimal(81),new BigDecimal(19)));
		lstDatos.add(new ChartjsData("Mayo",new BigDecimal(56),new BigDecimal(86)));
		lstDatos.add(new ChartjsData("Junio",new BigDecimal(55),new BigDecimal(27)));
		lstDatos.add(new ChartjsData("Julio",new BigDecimal(40),new BigDecimal(90)));
		
		
		Chartjs c1=new Chartjs("bar",columnas,lstDatos);
		c1.generar();
		
		Chartjs c2=new Chartjs("doughnut",columnas,lstDatos);
		c2.generar();
		
		Chartjs c3=new Chartjs("pie",columnas,lstDatos);
		c3.generar();
		
		Chartjs c4=new Chartjs("line",columnas,lstDatos);
		c4.generar();
		
		lst.add(c1);
		lst.add(c2);
		lst.add(c3);
		lst.add(c4);
		
		System.out.println("columnas");
	}

}
