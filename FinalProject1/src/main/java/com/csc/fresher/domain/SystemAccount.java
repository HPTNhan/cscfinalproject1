package com.csc.fresher.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the systemaccount database table.
 * 
 */
@Entity
@Table(name="systemaccount")
@NamedQuery(name="SystemAccount.findAll", query="SELECT s FROM SystemAccount s")
public class SystemAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String password;

	@Column(length=45)
	private String role;

	@Column(length=45)
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