package com.foodies1.dao;

import java.util.List;

import com.foodies1.model.Users;

public interface UserDao {
	int addUser(Users user);
	Users getUser(String phone_number);
	List<Users> getAll();
	void updateUser(Users user);
	int deleteUser(int u_id );
}
