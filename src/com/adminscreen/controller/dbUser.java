package com.adminscreen.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class dbUser {

	
	String id;

	String username;
	
	String usersurname;

	String telephone;

	public dbUser() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsersurname() {
		return usersurname;
	}

	public void getUsersurname(String usersurname) {
		this.usersurname = usersurname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/*public dbUser(String username, String usersurname,String telephone) {
		super();
		this.username = username;
		this.usersurname = usersurname;
		this.telephone = telephone;
	}*/

}