package com.foodies1.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodies1.dao.UserDao;
import com.foodies1.model.Users;

public class UserDaoImpl implements UserDao {
	private Connection con;

	private PreparedStatement pstmt;

	public final static String INSERTQUERY = "insert into users(name,mail,phone_number,username,password,address) values (?,?,?,?,?,?)";
	public final static String SELECT_ONE = "select * from users where phone_number=?";
	public final static String SELECT_ALL = "select * from users";
	public final static String UPDATE_QUERY = "update users set name=?,mail=?,phone_number=?,username=?,password=?,address=? where u_id=?";
	public final static String DELETE_QUERY = "delete from users where u_id=?";

	public UserDaoImpl() {

		String host = System.getenv().getOrDefault("MYSQLHOST", "localhost");
		String port = System.getenv().getOrDefault("MYSQLPORT", "3306");
		String database = System.getenv().getOrDefault("MYSQLDATABASE", "foodies");

		String url = "jdbc:mysql://" + host + ":" + port + "/" + database
				+ "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

		String username = System.getenv().getOrDefault("MYSQLUSER", "root");
		String password = System.getenv().getOrDefault("MYSQLPASSWORD", "");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int addUser(Users user) {

		try {
			pstmt = con.prepareStatement(INSERTQUERY);

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getMail());
			pstmt.setString(3, user.getPhone_number());
			pstmt.setString(4, user.getUsername());
			pstmt.setString(5, user.getPassword());
			pstmt.setString(6, user.getAddress());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public Users getUser(String phone_number) {
		ResultSet rset = null;
		Users user = null;
		try {
			pstmt = con.prepareStatement(SELECT_ONE);
			pstmt.setString(1, phone_number);

			rset = pstmt.executeQuery();
			if (rset.next()) {

				//				int id = rset.getInt("u_id");
				String name = rset.getString("name");
				String mail = rset.getString("mail");
				String num = rset.getString("phone_number");
				String uname = rset.getString("username");
				String password = rset.getString("password");
				String address = rset.getString("address");

				user = new Users(name, mail, num, uname, password, address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public List<Users> getAll() {

		ResultSet res =null;
		Users user =null;

		ArrayList<Users> userList = new ArrayList<Users>();

		try {
			Statement stmt = con.createStatement();
			res = stmt.executeQuery(SELECT_ALL);

			while(res.next()) {
				int id = res.getInt("u_id");
				String name = res.getString("name");
				String mail = res.getString("mail");
				String num = res.getString("phone_number");
				String uname = res.getString("username");
				String password = res.getString("password");
				String address = res.getString("address");

				user =new Users(name, mail, num, uname, password, address);

				userList.add(user);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void updateUser(Users user) {

		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getMail());
			pstmt.setString(3, user.getPhone_number());
			pstmt.setString(4, user.getUsername());
			pstmt.setString(5, user.getPassword());
			pstmt.setInt(6, user.getId());

			pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int deleteUser(int u_id) {
		int x = 0;
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, u_id);

			x= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;

	}

}
