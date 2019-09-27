package com.userinfo.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Accounts")
@Component
public class Accounts {
	@Id
    @Column(name="User_Name")
    private String user_name;
	
    @Column(name="Active")
    private boolean active;
    
    @Column(name="Password")
    private String password;
    
    @Column(name="User_Role")
    private String user_role;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	@Override
	public String toString() {
		return "Accounts [user_name=" + user_name + ", active=" + active + ", password=" + password + ", user_role="
				+ user_role + "]";
	}
}