package net.royal.spring.framework.core.dominio.chartsjs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PolarArea {
	
	private String label;
	private List<String> backgroundColor;
	private List<BigDecimal> data;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<String> getBackgroundColor() {
		if (backgroundColor==null)
			backgroundColor=new ArrayList<String>();
		return backgroundColor;
	}
	public void setBackgroundColor(List<String> backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public List<BigDecimal> getData() {
		if (data==null)
			data=new ArrayList<BigDecimal>();
		return data;
	}
	public void setData(List<BigDecimal> data) {
		this.data = data;
	}		
}
