package net.royal.spring.framework.core.dominio.chartsjs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pie {
	
	private List<String> hoverBackgroundColor;
	private List<String> backgroundColor;
	private List<BigDecimal> data;
	
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
	public List<String> getHoverBackgroundColor() {
		if (hoverBackgroundColor==null)
			hoverBackgroundColor=new ArrayList<String>();
		return hoverBackgroundColor;
	}
	public void setHoverBackgroundColor(List<String> hoverBackgroundColor) {
		this.hoverBackgroundColor = hoverBackgroundColor;
	}	
	
}
