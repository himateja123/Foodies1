package com.foodies1.model;

public class Orders {
	
	private int order_id;
	private int restaurant_id;
	private int u_id;
	private double totalAmount;
	private String modeofPayment;
	private String status;
	private String address;
	
	public Orders() {
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getModeofPayment() {
		return modeofPayment;
	}

	public void setModeofPayment(String modeofPayment) {
		this.modeofPayment = modeofPayment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Orders(int order_id, int restaurant_id, int u_id, double totalAmount, String modeofPayment, String status,String address) {
		super();
		this.order_id = order_id;
		this.restaurant_id = restaurant_id;
		this.u_id = u_id;
		this.totalAmount = totalAmount;
		this.modeofPayment = modeofPayment;
		this.status = status;
		this.address=address;
	}
	
	public Orders(double totalAmount, String modeofPayment,String address) {
		super();
//		this.order_id = order_id;
		this.u_id = u_id;
		this.totalAmount = totalAmount;
		this.modeofPayment = modeofPayment;
		this.address=address;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", restaurant_id=" + restaurant_id + ", u_id=" + u_id + ", totalAmount="
				+ totalAmount + ", modeofPayment=" + modeofPayment + ", status=" + status + "]";
	}
	
	
}
