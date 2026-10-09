package com.foodies1.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodies1.dao.OrderDao;
import com.foodies1.model.Orders;

public class OrderDaoImpl implements OrderDao {

	static final String ADD_ORDER="insert into orders(totalAmount,modeofPayment,address) values (?,?,?)";
	static final String GET_ORDER ="select * from orders where order_id=?";
	static final String GET_ALL ="select * from orders";
	static final String UPDATE_ORDER="update orders set totalAmount=?,status=? where order_id=?";
	static final String DELETE_ORDER="delete from orders where order_id=?";
	private Connection con;


	private PreparedStatement pstmt;
	private Statement stmt;
	public OrderDaoImpl() {
        con = DatabaseConnection.getConnection();
    }

	@Override
	public int addOrder(Orders order) {

		try {
			pstmt = con.prepareStatement(ADD_ORDER);
			//			pstmt.setInt(1, order.getRestaurant_id());
			//			pstmt.setInt(1, order.getU_id());
			pstmt.setDouble(1, order.getTotalAmount());
			pstmt.setString(2, order.getModeofPayment());
			pstmt.setString(3, order.getAddress());
			//			pstmt.setString(5, order.getStatus());

			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Orders getOrder(int order_id) {

		Orders order=null;

		try {
			pstmt = con.prepareStatement(GET_ORDER);
			ResultSet res = pstmt.executeQuery();

			if(res.next()) {
				int orderid =res.getInt("order_id");
				int userid =res.getInt("u_id");
				double amount =res.getDouble("totalAmount");
				String modeofpay =res.getString("modeofPayment");
				String status =res.getString("status");

				order =new Orders(orderid,0,userid,amount,modeofpay,status,null);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Orders> getAll() {

		List<Orders> list =new ArrayList<Orders>();
		Orders order=null;

		try {
			stmt =con.createStatement();
			ResultSet res = stmt.executeQuery(GET_ALL);

			int orderid =res.getInt("order_id");
			int userid =res.getInt("u_id");
			double amount =res.getDouble("totalAmount");
			String modeofpay =res.getString("modeofPayment");
			String status =res.getString("status");

			order = new Orders(orderid,0,userid,amount,modeofpay,status,null);
			list.add(order);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateOrder(Orders order) {

		try {
			pstmt = con.prepareStatement(UPDATE_ORDER);

			pstmt.setDouble(1, order.getTotalAmount());
			pstmt.setString(2, order.getStatus());

			pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int deleteOrder(int order_id) {

		try {
			pstmt  = con.prepareStatement(DELETE_ORDER);

			pstmt.setInt(1, order_id);
			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
