package com.foodies1.model;

public class CartItem {
	
	private int menu_id;
	private String itemName;
	private String imagePath;
	private int price;
	private int quantity;
	
	public CartItem() {
	}

	public CartItem(int menu_id, String itemName, String imagePath, int price, int quantity) {
		super();
		this.menu_id = menu_id;
		this.itemName = itemName;
		this.price = price;
		this.imagePath=imagePath;
		this.quantity = quantity;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int item_id) {
		this.menu_id = item_id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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

	public int getQuantity() {
		return quantity;
	}

	public int setQuantity(int quantity) {
		return this.quantity = quantity;
	}
	
	
}
