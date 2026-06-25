package com.foodies1.dao;

import java.util.List;

import com.foodies1.model.Menu;

public interface MenuDao {
	
	int addMenu(Menu menu);
	List<Menu> getMenu(int restaurant_id);
	List<Menu> getAllMenu();
	int updateMenu(Menu menu);
	int deleteMenu(int menu_id);
	Menu getMenuById(int menu_id);
}
