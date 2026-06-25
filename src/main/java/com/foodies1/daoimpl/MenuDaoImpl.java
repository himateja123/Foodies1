package com.foodies1.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodies1.dao.MenuDao;
import com.foodies1.model.Menu;

public class MenuDaoImpl implements MenuDao {

	
	static final String ADD_MENU="insert into menu(itemName,price,imagePath,ratings,isAvailable,restaurant_id) values (?,?,?,?,?,?)";
	static final String GET_MENU="select * from menu where restaurant_id=?";
	static final String GET_ALL="select * from menu";
	static final String UPDATE_MENU="update menu set itemName=?,price=?,ratings=?,isAvailable=? where name=?";
	static final String DELETE_MENU="delete from menu where menu_id=?";
	static final String GETMENUBY_ID ="select menu_id, itemName, imagePath, price from menu where menu_id=?";
	
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;

	public MenuDaoImpl() {
		
		String url = "jdbc:mysql://localhost:3306/foodies";
		String username = "root";
		String password = "Himateja1234*";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addMenu(Menu menu) {
		try {
			pstmt =con.prepareStatement(ADD_MENU);
			pstmt.setString(1, menu.getItemName());
			pstmt.setInt(2, menu.getPrice());
			pstmt.setString(3, menu.getImagePath());
			pstmt.setFloat(4, menu.getRatings());
			pstmt.setBoolean(5, menu.getisAvailable());
			pstmt.setInt(6, menu.getRestaurant_id());
			
			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Menu> getMenu(int restaurant_id) {
		Menu menu=null;
		List<Menu> addMenu = new ArrayList<Menu>();
		try {
			pstmt =con.prepareStatement(GET_MENU);
			pstmt.setInt(1, restaurant_id);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int m_id =res.getInt("menu_id");
				String itemname =res.getString("itemName");
				int price =res.getInt("price");
				String img=res.getString("imagePath");
				float rating =res.getFloat("ratings");
				boolean isavail =res.getBoolean("isAvailable");
				int rest_id =res.getInt("restaurant_id");
				String desc=res.getString("description");
				
				menu = new Menu(m_id,itemname,price,img,rating,isavail,rest_id,desc);
				addMenu.add(menu);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return addMenu;
	}

	@Override
	public List<Menu> getAllMenu() {
		List<Menu> addMenu = new ArrayList<Menu>();
		Menu menu=null;
		try {
			stmt =con.createStatement();
			ResultSet res = stmt.executeQuery(GET_ALL);
			
			while(res.next()) {
				int m_id =res.getInt("menu_id");
				String itemname =res.getString("itemName");
				int price =res.getInt("price");
				float rating =res.getFloat("ratings");
				boolean isavail =res.getBoolean("isAvailable");
				int rest_id =res.getInt("restaurant_id");
				String desc=res.getString("description");
				
				menu = new Menu(m_id,itemname,price,null,rating,isavail,rest_id,desc);
				addMenu.add(menu);
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return addMenu;
	}

	@Override
	public int updateMenu(Menu menu) {
		
		try {
			pstmt =con.prepareStatement(UPDATE_MENU);
			pstmt.setString(1, menu.getItemName());
			pstmt.setInt(2, menu.getPrice());
			pstmt.setFloat(3, menu.getRatings());
			pstmt.setBoolean(4, menu.getisAvailable());
			
			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteMenu(int menu_id) {
		try {
			pstmt =con.prepareStatement(DELETE_MENU);
			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Menu getMenuById(int menu_id) {
		
		Menu menu=null;
		try {
			
			pstmt = con.prepareStatement(GETMENUBY_ID);
			pstmt.setInt(1, menu_id);
			
			ResultSet res = pstmt.executeQuery();

	        if (res.next()) {
	            menu = new Menu();

	            menu.setMenu_id(res.getInt("menu_id"));
	            menu.setItemName(res.getString("itemName"));
	            menu.setImagePath(res.getString("imagePath"));
	            menu.setPrice(res.getInt("price"));
	        }
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return menu;
	}

}
