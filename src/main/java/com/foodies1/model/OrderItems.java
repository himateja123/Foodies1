package com.foodies1.model;

public class OrderItems {
	private int orderitems_id;
	private int u_id;
	private int menu_id;
	private String name;
	private int quantity;
	private float ratings;
	private int price;
	
	public OrderItems() {
	}

	public int getOrderitems_id() {
		return orderitems_id;
	}

	public void setOrderitems_id(int orderitems_id) {
		this.orderitems_id = orderitems_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public OrderItems( int u_id, int menu_id, String name, int quantity, float ratings, int price) {
		super();
		this.u_id = u_id;
		this.menu_id = menu_id;
		this.name = name;
		this.quantity = quantity;
		this.ratings = ratings;
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderItems [orderitems_id=" + orderitems_id + ", u_id=" + u_id + ", menu_id=" + menu_id + ", name="
				+ name + ", quantity=" + quantity + ", ratings=" + ratings + ", price=" + price + "]";
	}
	
	
	
}
