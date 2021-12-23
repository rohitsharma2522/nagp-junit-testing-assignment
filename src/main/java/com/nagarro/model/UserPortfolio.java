package com.nagarro.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userportfolio")
public class UserPortfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long uid;
	 @Column(name="userId")
	private String userId;
	private double balance;
	 

	@OneToMany(mappedBy="up")
	private List<Holding> holdings;

	public UserPortfolio() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public UserPortfolio(String userId, double balance, List<Holding> holdings) {
		super();
		this.userId = userId;
		this.balance = balance;
		this.holdings = holdings;
	}


	public Long getId() {
		return uid;
	}

	public void setId(Long uid) {
		this.uid = uid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Holding> getHoldings() {
		return holdings;
	}

	public void setHoldings(List<Holding> holdings) {
		this.holdings = holdings;
	}
	
}
