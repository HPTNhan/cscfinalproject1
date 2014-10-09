package com.csc.fresher.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the systemaccount database table.
 * 
 */
@Entity
@NamedQuery(name="SystemAccount.findAll", query="SELECT s FROM SystemAccount s")
public class SystemAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String password;

	private String role;

	private String username;

	public SystemAccount() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}