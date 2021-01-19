package net.royal.spring.framework.core.dominio.chartsjs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Radar {
	private String label;

	private String backgroundColor;
	private String borderColor;
	private String pointBackgroundColor;
	private String pointBorderColor;
	private String pointHoverBackgroundColor;
	private String pointHoverBorderColor;

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

	public String getPointBackgroundColor() {
		return pointBackgroundColor;
	}

	public void setPointBackgroundColor(String pointBackgroundColor) {
		this.pointBackgroundColor = pointBackgroundColor;
	}

	public String getPointBorderColor() {
		return pointBorderColor;
	}

	public void setPointBorderColor(String pointBorderColor) {
		this.pointBorderColor = pointBorderColor;
	}

	public String getPointHoverBackgroundColor() {
		return pointHoverBackgroundColor;
	}

	public void setPointHoverBackgroundColor(String pointHoverBackgroundColor) {
		this.pointHoverBackgroundColor = pointHoverBackgroundColor;
	}

	public String getPointHoverBorderColor() {
		return pointHoverBorderColor;
	}

	public void setPointHoverBorderColor(String pointHoverBorderColor) {
		this.pointHoverBorderColor = pointHoverBorderColor;
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
