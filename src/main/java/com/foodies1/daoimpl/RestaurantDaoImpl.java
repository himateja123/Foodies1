package com.foodies1.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodies1.dao.RestaurantDao;
import com.foodies1.model.Restaurants;

public class RestaurantDaoImpl implements RestaurantDao{


	public final static String INSERT="insert into restaurants(name,imagePath,ratings,cuisineType,address,isActive) values (?,?,?,?,?,?)";
	public final static String GET_RESTAURANT="select * from restaurants where restaurant_id=?";
	public final static String SELECT_ALL="select * from restaurants";
	public final static String UPDATE="update restaurants set name=?,imagePath=?,ratings=?,cuisineType=?,address=?,isActive=? where restaurant_id=?";
	public final static String DELETE="delete from restaurants where restaurant_id=?";



	private Connection con;
	private PreparedStatement pstmt;
	private int r_id;
	private String name;
	private float ratings;
	private String cuisine;
	private String address;
	private boolean isactive;

	public RestaurantDaoImpl() {
		String url = "jdbc:mysql://localhost:3306/foodies";
		String username="root";
		String password="Himateja1234*";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con  = DriverManager.getConnection(url, username, password);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int addRestaurant(Restaurants restaurant) {

		try {
			pstmt =con.prepareStatement(INSERT);
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getImagePath());
			pstmt.setFloat(3, restaurant.getRatings());
			pstmt.setString(4, restaurant.getCuisineType());
			pstmt.setString(5, restaurant.getAddress());
			pstmt.setBoolean(6, restaurant.getIsActive());

			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Restaurants getRestaurant(int restaurant_id) {
		Restaurants rest=null;

		try {
			pstmt =con.prepareStatement(GET_RESTAURANT);
			pstmt.setInt(1, restaurant_id);

			ResultSet res = pstmt.executeQuery();

			if(res.next()) {
				int r_id = res.getInt("restaurant_id");
				String name=res.getString("name");
				float ratings=res.getFloat("ratings");
				String cuisine =res.getString("cuisineType");
				String address=res.getString("address");
				boolean isactive=res.getBoolean("isActive");

			}
			rest = new Restaurants(r_id, name, null, ratings, cuisine, address, isactive);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return rest;
	}

	@Override
	public List<Restaurants> getAll() {
		
		ResultSet res=null;
		Restaurants rest=null;
		List <Restaurants> restaurantList =new ArrayList<>();
		
		try {
			Statement stmt = con.createStatement();
			res = stmt.executeQuery(SELECT_ALL);
			
			while(res.next()) {
				int r_id = res.getInt("restaurant_id");
				String name=res.getString("name");
				String imagept=res.getString("imagePath");
				float ratings=res.getFloat("ratings");
				String cuisine =res.getString("cuisineType");
				String address=res.getString("address");
				boolean isactive=res.getBoolean("isActive");
				
				rest = new Restaurants(r_id, name,imagept,ratings,cuisine,address,isactive);
				
				restaurantList.add(rest);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurantList;
	}

	@Override
	public void updateRestaurant(Restaurants restaurant) {

		try {
			pstmt =con.prepareStatement(UPDATE);
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getImagePath());
			pstmt.setFloat(3, restaurant.getRatings());
			pstmt.setBoolean(4, restaurant.getIsActive());
			pstmt.setInt(5, restaurant.getRestaurant_id());

			pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public int deleteRestaurant(int restaurant_id) {
		int x=0;
		try {
			pstmt =con.prepareStatement(DELETE);
			pstmt.setInt(1, restaurant_id);
			x = pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return x;
	}





}
