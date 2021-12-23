package com.nagarro.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nagarro.model.Equity;
import com.nagarro.model.FundsSuccessResponse;
import com.nagarro.model.TradeResponse;
import com.nagarro.model.UserPortfolio;
import com.nagarro.service.TradeService;
import com.nagarro.service.UserPortfolioService;

class UserPortfolioControllerTest {

	@InjectMocks
	private UserPortfolioController userPortfolioController;
	
	@Mock
	private UserPortfolioService userPortfolioService;
	
	@Mock
	private UserPortfolio userPortfolio;
	
	@Mock
	private FundsSuccessResponse fundsSuccessResponse;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	 public void shouldCreateNewUser(){
		
	     UserPortfolio userPortfolioData = new UserPortfolio("1", 2000, null);
	     Mockito.when(userPortfolioService.createUser(userPortfolio)).thenReturn(userPortfolioData);
	     Assertions.assertEquals(userPortfolioData.getUserId(),userPortfolioController.createUser(userPortfolio).getUserId());
	 }
	
}
