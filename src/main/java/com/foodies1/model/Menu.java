package com.foodies1.model;

public class Menu {
	
	private int menu_id;
	private String itemName;
	private int price;
	private String imagePath;
	private float ratings;
	private boolean isAvailable;
	private int restaurant_id;
	private String description;
	
	public Menu() {
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public boolean getisAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Menu(int menu_id, String itemName, int price, String imagePath, float ratings, boolean isAvailable,
			int restaurant_id,String description) {
		super();
		this.menu_id = menu_id;
		this.itemName = itemName;
		this.price = price;
		this.imagePath = imagePath;
		this.ratings = ratings;
		this.isAvailable = isAvailable;
		this.restaurant_id = restaurant_id;
		this.description=description;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", itemName=" + itemName + ", price=" + price + ", imagePath=" + imagePath
				+ ", ratings=" + ratings + ", isAvailable=" + isAvailable + ", restaurant_id=" + restaurant_id
				+ ", description=" + description + "]";
	}

	
	
	
	
	
}
