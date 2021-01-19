package net.royal.spring.framework.core.dominio.chartsjs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bar {
	
	/**
	 * bar
	 */
	private String label;
	
	/**
	 * bar
	 */
	private String backgroundColor;
	
	/**
	 * bar
	 */
	private String borderColor;
		
	/**
	 * bar
	 */
	private List<BigDecimal> data;
	
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
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
