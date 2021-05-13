package com.senla.povargo.hotel.console.menu;

import com.senla.povargo.hotel.console.menu.items.MenuItem;
import org.springframework.stereotype.Component;

@Component
public class Menu {

	private String name;
	private MenuItem[] menuItems;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MenuItem[] getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}

}
