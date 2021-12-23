package com.nagarro.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.model.Trade;
import com.nagarro.model.TradeResponse;

@Service
public interface TradeService {
	public TradeResponse buyEquity(String userId, Trade tradedetails);
	public TradeResponse sellEquity(String userId, Trade tradedetails);
}
