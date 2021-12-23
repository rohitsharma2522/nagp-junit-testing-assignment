package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Trade;
import com.nagarro.model.TradeResponse;
import com.nagarro.service.TradeService;

@RestController

public class TradeController {
	
	@Autowired
	TradeService tradeService;
	
	
	@PostMapping("/buy/{userId}")
	  public TradeResponse buyEquity(@PathVariable("userId") String userId, @RequestBody Trade details) {
		return tradeService.buyEquity(userId, details);
	}
	
	@PostMapping("/sell/{userId}")
	  public TradeResponse sellEquity(@PathVariable("userId") String userId, @RequestBody Trade details) {
		return tradeService.sellEquity(userId, details);
	}

}
