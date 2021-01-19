package net.royal.spring.framework.core.dominio.chartsjs;

import java.util.ArrayList;
import java.util.List;

public class Chartjs {
	
	/**
	 * azul,verde,rosa,mostaza,gris,AQUA,GREEN,violeta	, ROJO,negro,guinda,azul marino,naranja,amarillo,verde agua,azul agua,especial,turquesa,violetanegro,azul negro
	 */
	private String[] listaColores = {"#42A5F5","#9CCC65","#FF6384","#FFCE56","#E7E9ED","#00FFFF","#008000","#FF33E0"
	,"#FF333C","#000000","#B20F0F","#875FF7","#F8A811","#E5FC00","#93F200","#297065","#18F7F7","#9E52A2","#433365"	,
	"#42A5F5","#9CCC65","#FF6384","#FFCE56","#E7E9ED","#00FFFF","#008000","#FF33E0"
	,"#FF333C","#000000","#B20F0F","#875FF7","#F8A811","#E5FC00","#93F200","#297065","#18F7F7","#9E52A2","#433365",
	"#42A5F5","#9CCC65","#FF6384","#FFCE56","#E7E9ED","#00FFFF","#008000","#FF33E0"
	,"#FF333C","#000000","#B20F0F","#875FF7","#F8A811","#E5FC00","#93F200","#297065","#18F7F7","#9E52A2","#433365",
	"#42A5F5","#9CCC65","#FF6384","#FFCE56","#E7E9ED","#00FFFF","#008000","#FF33E0"
	,"#FF333C","#000000","#B20F0F","#875FF7","#F8A811","#E5FC00","#93F200","#297065","#18F7F7","#9E52A2","#433365",
	"#42A5F5","#9CCC65","#FF6384","#FFCE56","#E7E9ED","#00FFFF","#008000","#FF33E0"
	,"#FF333C","#000000","#B20F0F","#875FF7","#F8A811","#E5FC00","#93F200","#297065","#18F7F7","#9E52A2","#433365"
	
	};
	
	/**
	 * bar,line,polarArea,doughnut,pie,radar
	 */
	private String type;
	
	/**
	 * bar,line,polarArea,doughnut,pie,radar
	 */
	private List<String> labels;
	
	/**
	 * bar,line,polarArea,doughnut,pie,radar
	 */
	private List datasets;
	
	private List<ChartjsData> listaDatos;
	private List<String> listaColumnas;
	private String titulo;
	
	public Chartjs() {}
	public Chartjs(String type,List<String> listaColumnas,List<ChartjsData> listaDatos) {
		this.type=type;
		this.listaColumnas=listaColumnas;
		this.listaDatos=listaDatos;
	}
	
	
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public List getDatasets() {
		return datasets;
	}
	public void setDatasets(List datasets) {
		this.datasets = datasets;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<ChartjsData> getListaDatos() {
		return listaDatos;
	}
	public void setListaDatos(List<ChartjsData> listaDatos) {
		this.listaDatos = listaDatos;
	}		
	
	public void generar() {
		if (listaDatos==null)
			listaDatos=new ArrayList<ChartjsData>();
		if (listaColumnas==null)
			listaColumnas=new ArrayList<String>();
		if (datasets==null)
			datasets=new ArrayList<>();
		if (type.equals("bar")) {
			generarLabels();
			if (listaColumnas.size()<=2)
				datasets.add(generarBar(1));
			/*if (listaColumnas.size()==3)
				datasets.add(generarBar(2));*/
		}
		if (type.equals("line")) {
			generarLabels();
			if (listaColumnas.size()<=2)
				datasets.add(generarBar(1));
			/*if (listaColumnas.size()<=3)
				datasets.add(generarBar(2));*/
		}
		if (type.equals("doughnut")) {
			generarLabels();
			if (listaColumnas.size()<=2)
				datasets.add(generarDoughnut(1));
			/*if (listaColumnas.size()<=3)
				datasets.add(generarDoughnut(2));*/
		}
		if (type.equals("pie")) {
			generarLabels();
			if (listaColumnas.size()<=2)
				datasets.add(generarPie(1));
			/*if (listaColumnas.size()<=3)
				datasets.add(generarPie(2));*/
		}
	}
	private Line generarLine(Integer columna) {
		Line b1=new Line();
		b1.setLabel(listaColumnas.get(columna));
		b1.setFill(Boolean.FALSE);
		//b1.setBorderColor(null);
		
		for (ChartjsData e : listaDatos) {
			if (columna==1)
				b1.getData().add(e.getValor1());
			if (columna==2)
				b1.getData().add(e.getValor2());
		}
		return b1;
	}
	private Pie generarPie(Integer columna) {
		Pie b1=new Pie();		
		int index=0;
		for (ChartjsData e : listaDatos) {
			if (columna==1) {
				b1.getData().add(e.getValor1());
				b1.getBackgroundColor().add(listaColores[index]);
				//b1.setHoverBackgroundColor(hoverBackgroundColor);
			}				
			if (columna==2) {
				b1.getData().add(e.getValor2());
				b1.getBackgroundColor().add(listaColores[index]);
				//b1.setHoverBackgroundColor(hoverBackgroundColor);
			}
			index++;
		}
		return b1;
	}
	private Doughnut generarDoughnut(Integer columna) {
		Doughnut b1=new Doughnut();		
		int index=0;
		for (ChartjsData e : listaDatos) {
			if (columna==1) {
				b1.getData().add(e.getValor1());
				b1.getBackgroundColor().add(listaColores[index]);
				//b1.setHoverBackgroundColor(hoverBackgroundColor);
			}				
			if (columna==2) {
				b1.getData().add(e.getValor2());
				b1.getBackgroundColor().add(listaColores[index]);
				//b1.setHoverBackgroundColor(hoverBackgroundColor);
			}
			index++;
		}
		return b1;
	}
	private Bar generarBar(Integer columna) {
		Bar b1=new Bar();
		b1.setLabel(listaColumnas.get(columna));
		b1.setBackgroundColor(listaColores[columna]);
		b1.setBorderColor(null);
		
		for (ChartjsData e : listaDatos) {
			if (columna==1)
				b1.getData().add(e.getValor1());
			if (columna==2)
				b1.getData().add(e.getValor2());
		}
		return b1;
	}
	
	private void generarLabels() {
		labels = new ArrayList<>();
		for (ChartjsData e : listaDatos) {
			labels.add(e.getNombre());
		}
	}
	public String[] getListaColores() {
		return listaColores;
	}
	public void setListaColores(String[] listaColores) {
		this.listaColores = listaColores;
	}
	public List<String> getListaColumnas() {
		return listaColumnas;
	}
	public void setListaColumnas(List<String> listaColumnas) {
		this.listaColumnas = listaColumnas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
