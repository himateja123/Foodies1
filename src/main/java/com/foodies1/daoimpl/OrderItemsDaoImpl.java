package com.foodies1.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.foodies1.dao.OrderItemsDao;
import com.foodies1.model.OrderItems;

public class OrderItemsDaoImpl implements OrderItemsDao {

	static final String INSERT_ORDERITEM="insert into orderitems(u_id,menu_id,name,quantity,ratings,price) values(?,?,?,?,?,?)";


	static final String UPDATE_ORDERITEM="update orderitems set name=?,quantity=?,ratings=?,price=? where orderitems_id=?";
	static final String DELETE_ORDERITEM="delete from orderitems orderitems_id=?";

	private Connection con;
	private PreparedStatement pstmt;


	public OrderItemsDaoImpl() {

		String url = "jdbc:mysql://localhost:3306/foodies";
		String username = "root";
		String password = "Himateja1234*";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addOrderItem(OrderItems oi) {

		try {
			pstmt = con.prepareStatement(INSERT_ORDERITEM);
			pstmt.setInt(1, oi.getMenu_id());
			pstmt.setInt(2, oi.getMenu_id());
			pstmt.setString(2, oi.getName());
			pstmt.setInt(4, oi.getQuantity());
			pstmt.setFloat(5, oi.getRatings());
			pstmt.setInt(6, oi.getPrice());

			return pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public OrderItems getOrderItem(int orderitems_id) {

		return null;
	}

	@Override
	public List<OrderItems> getAll() {

		return null;
	}

	@Override
	public void updateOrderItem(OrderItems oi) {

		try {
			pstmt = con.prepareStatement(UPDATE_ORDERITEM);
			pstmt.setString(1, oi.getName());
			pstmt.setInt(2, oi.getQuantity());
			pstmt.setFloat(3, oi.getRatings());
			pstmt.setInt(4, oi.getPrice());

			pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int deleteOrderItem(int orderitems_id) {

		try {
			pstmt = con.prepareStatement(DELETE_ORDERITEM);
			pstmt.setInt(1, orderitems_id);

			return pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
