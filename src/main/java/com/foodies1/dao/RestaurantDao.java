package com.foodies1.dao;

import java.util.List;

import com.foodies1.model.Restaurants;

public interface RestaurantDao {
	
	int addRestaurant(Restaurants restaurant);
	Restaurants getRestaurant(int restaurant_id);
	List<Restaurants> getAll();
	void updateRestaurant(Restaurants restaurant);
	int deleteRestaurant(int restaurant_id);
}
