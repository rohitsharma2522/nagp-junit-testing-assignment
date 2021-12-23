package com.nagarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equity")
public class Equity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "eid")
	private Long eid;
	@Id  
	private String stockName;
	private double currentPrice;
	
	 @OneToOne(mappedBy = "equities")
    private Holding holding;
	
	public Equity() {}
	
	public Equity(String stockName, double currentPrice) {
		super();
		this.stockName = stockName;
		this.currentPrice = currentPrice;
	}
	public Long getEid() {
		return eid;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	
}
