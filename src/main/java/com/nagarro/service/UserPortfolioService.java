package com.nagarro.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.model.FundsSuccessResponse;
import com.nagarro.model.UserPortfolio;

@Service
public interface UserPortfolioService {

	public UserPortfolio createUser(UserPortfolio userData);
	public UserPortfolio getUserByUserId(String userId);
	public FundsSuccessResponse addFunds(String userId, double funds);
	
}
