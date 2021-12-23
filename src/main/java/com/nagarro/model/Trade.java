package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trade")
public class Trade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String stockName;
	private int qty;
	
	public Trade() {
		// TODO Auto-generated constructor stub
	}
	
	public Trade(String stockName, int qty) {
		super();
		this.stockName = stockName;
		this.qty = qty;
	}

	public long getId() {
		return id;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
