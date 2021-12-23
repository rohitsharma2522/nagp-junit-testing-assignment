package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Equity;
import com.nagarro.model.FundsSuccessResponse;
import com.nagarro.model.Trade;
import com.nagarro.model.TradeResponse;
import com.nagarro.model.UserPortfolio;
import com.nagarro.service.UserPortfolioService;


@RestController
public class UserPortfolioController {
	
	@Autowired
	UserPortfolioService userPortfolioService;
	

	@PostMapping("/createuser")
	  public UserPortfolio createUser(@RequestBody UserPortfolio userData) {
		return userPortfolioService.createUser(userData);
	}
	@PostMapping("/addFunds/{userId}")
	  public FundsSuccessResponse addFunds(@PathVariable("userId") String userId, double funds) {
		return userPortfolioService.addFunds(userId, funds);
	}
	
	@GetMapping("/getPortfolio/{userId}")
	  public UserPortfolio getEquityByName(@PathVariable("userId") String userId) {
		
		return userPortfolioService.getUserByUserId(userId);
	
	}

}
