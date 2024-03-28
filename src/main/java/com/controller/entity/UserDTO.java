package com.controller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_info")

public class UserDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	@Column
	private String username;
	@Column
    private String password;
	@Column
    private String user_fullname;
	@Column
    private String phone_no;
	@Column
    private String email;
	@Column
    private String user_address;
	
	
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(String username, String password, String user_fullname, String phone_no, String email,
			String user_address) {
		super();
		this.username = username;
		this.password = password;
		this.user_fullname = user_fullname;
		this.phone_no = phone_no;
		this.email = email;
		this.user_address = user_address;
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
	public String getUser_fullname() {
		return user_fullname;
	}
	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
   
   
}
