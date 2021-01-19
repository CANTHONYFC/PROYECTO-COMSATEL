package net.royal.spring.framework.core.dominio.chartsjs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Line {
	
	/**
	 * line
	 */
	private String label;
		
	/**
	 * line
	 */
	private String borderColor;
		
	/**
	 * line
	 */
	private List<BigDecimal> data;
	
	/**
	 * line
	 */
	private Boolean fill;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
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
	public Boolean getFill() {
		return fill;
	}
	public void setFill(Boolean fill) {
		this.fill = fill;
	}	
	
}
