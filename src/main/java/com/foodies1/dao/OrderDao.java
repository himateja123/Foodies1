package com.foodies1.dao;

import java.util.List;

import com.foodies1.model.Orders;
import com.foodies1.model.Users;

public interface OrderDao {
	
	int addOrder(Orders order);
	Orders getOrder(int order_id);
	List<Orders> getAll();
	void updateOrder(Orders order);
	int deleteOrder(int order_id);
}
