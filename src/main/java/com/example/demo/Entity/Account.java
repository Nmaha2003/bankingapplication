package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity

@Table(name="accountss")
public class Account {

public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
public long getId() {
		return id;
	}
	public Account(long id, String accountHoldername, double balance) {
	super();
	this.id = id;
	this.accountHoldername = accountHoldername;
	this.balance = balance;
}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountHoldername() {
		return accountHoldername;
	}
	public void setAccountHoldername(String accountHoldername) {
		this.accountHoldername = accountHoldername;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
@Column(name="account_holder_name")
private String accountHoldername;
private double balance;
}
