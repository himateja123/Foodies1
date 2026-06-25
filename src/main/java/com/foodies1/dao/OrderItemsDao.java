package com.foodies1.dao;

import java.util.List;

import com.foodies1.model.OrderItems;

public interface OrderItemsDao {
	
	int addOrderItem(OrderItems oi);
	OrderItems getOrderItem(int orderitems_id);
	List<OrderItems> getAll();
	void updateOrderItem(OrderItems oi);
	int deleteOrderItem(int orderitems_id);
}
