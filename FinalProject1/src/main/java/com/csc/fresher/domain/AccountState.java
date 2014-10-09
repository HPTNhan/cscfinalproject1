package com.csc.fresher.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the accountstate database table.
 * 
 */
@Entity
@NamedQuery(name="AccountState.findAll", query="SELECT a FROM AccountState a")
public class AccountState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idstate;

	private String stateName;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="accountstate")
	private List<Account> accounts;

	public AccountState() {
	}

	public int getIdstate() {
		return this.idstate;
	}

	public void setIdstate(int idstate) {
		this.idstate = idstate;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setAccountstate(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setAccountstate(null);

		return account;
	}

}