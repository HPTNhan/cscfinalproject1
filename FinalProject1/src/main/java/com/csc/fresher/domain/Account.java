package com.csc.fresher.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idaccount;

	private String accountNumber;

	private String address1;

	private String address2;

	private String email1;

	private String email2;

	private String firstName;

	private String idCardNumber;

	private String lastName;

	private String midName;

	private String phoneNumber1;

	private String phoneNumber2;

	//bi-directional many-to-one association to AccountState
	@ManyToOne
	@JoinColumn(name="idstate")
	private AccountState accountstate;

	//bi-directional many-to-one association to AccountType
	@ManyToOne
	@JoinColumn(name="idtype")
	private AccountType accounttype;

	public Account() {
	}

	public int getIdaccount() {
		return this.idaccount;
	}

	public void setIdaccount(int idaccount) {
		this.idaccount = idaccount;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getEmail1() {
		return this.email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIdCardNumber() {
		return this.idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMidName() {
		return this.midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getPhoneNumber1() {
		return this.phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return this.phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public AccountState getAccountstate() {
		return this.accountstate;
	}

	public void setAccountstate(AccountState accountstate) {
		this.accountstate = accountstate;
	}

	public AccountType getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(AccountType accounttype) {
		this.accounttype = accounttype;
	}

}