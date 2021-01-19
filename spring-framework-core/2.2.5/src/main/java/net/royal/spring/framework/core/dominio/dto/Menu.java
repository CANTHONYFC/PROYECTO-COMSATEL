package net.royal.spring.framework.core.dominio.dto;

import java.util.List;

public class Menu {
	private List<Item> items;

	public Menu() {
	}

	public Menu(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
