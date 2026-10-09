package com.foodies1.model;

import java.sql.Timestamp;
import java.sql.Date;

public class Users {


	private int u_id;
	private String name;
	private String mail;
	private String phone_number;
	private String username;
	private String password;
	private String address;
	private String role;
	private Date created_date;
	private Timestamp last_login;


	public int getId() {
		return u_id;
	}
	public void setId(int id) {
		this.u_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Timestamp getLast_login() {
		return last_login;
	}
	public void setLast_login(Timestamp last_login) {
		this.last_login = last_login;
	}
	
	public Users() {
	}
	
	public Users( String name, String mail, String phone_number, String username, String password,
			String address) {
		super();
		this.u_id = u_id;
		this.name = name;
		this.mail = mail;
		this.phone_number = phone_number;
		this.username = username;
		this.password = password;
		this.address = address;
		this.role = role;
		this.created_date = created_date;
		this.last_login = last_login;
	}


	@Override
	public String toString() {
		return "Users [u_id=" + u_id + ", name=" + name + ", mail=" + mail + ", phone_number=" + phone_number
				+ ", username=" + username + ", password=" + password + ", address=" + address + ", role=" + role
				+ ", created_date=" + created_date + ", last_login=" + last_login + "]";
	}










}
