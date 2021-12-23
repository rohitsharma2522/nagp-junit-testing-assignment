package com.nagarro.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Holding {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long hid;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equity_id", referencedColumnName = "eid")
    private Equity equities;

	private int qty;
	
	@ManyToOne
	@JoinColumn(name = "up_id", referencedColumnName = "id")
	private UserPortfolio up;

	public Holding() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Holding(Equity equities, int qty) {
		super();
		this.equities = equities;
		this.qty = qty;
	}
	
	public long getHid() {
		return hid;
	}

	public Equity getEquities() {
		return equities;
	}

	public void setEquities(Equity equities) {
		this.equities = equities;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
}
