package com.nagarro.utils;

public class BrokerageUtils {
	
	public static double  brokerageRate = 0.5d;
	
	public static double computeBrokerage(int qty, double price) {
		return (0.5d * qty * price)/100;
	}

}
