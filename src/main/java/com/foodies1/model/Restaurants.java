package com.foodies1.model;

public class Restaurants {
	
	
	private int restaurant_id;
	private String name;
	private String imagePath;
	private float ratings;
	private String cuisineType;
	private String address;
	private boolean isActive;
	private int restaurant_owner_id;
	
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getRestaurant_owner_id() {
		return restaurant_owner_id;
	}
	public void setRestaurant_owner_id(int restaurant_owner_id) {
		this.restaurant_owner_id = restaurant_owner_id;
	}
	
	public Restaurants() {
	}
	
	
	public Restaurants(int restaurant_id, String name, String imagePath, float ratings, String cuisineType,
			String address, boolean isActive) {
		super();
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.imagePath = imagePath;
		this.ratings = ratings;
		this.cuisineType = cuisineType;
		this.address = address;
		this.isActive = isActive;
		this.restaurant_owner_id = restaurant_owner_id;
	}
	@Override
	public String toString() {
		return "Restaurants [restaurant_id=" + restaurant_id + ", name=" + name + ", imagePath=" + imagePath
				+ ", ratings=" + ratings + ", cuisineType=" + cuisineType + ", address=" + address + ", isActive="
				+ isActive + ", restaurant_owner_id=" + restaurant_owner_id + "]";
	}
	
	
	
	
	
	
}
