package com.nagarro.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nagarro.controller.UserPortfolioController;
import com.nagarro.model.FundsSuccessResponse;
import com.nagarro.model.UserPortfolio;

class UserPortfolioServiceTest {

	@Mock
	UserPortfolioService userPortfolioService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void addFunds () {
		UserPortfolio user = new UserPortfolio("1", 2500, null);
		FundsSuccessResponse resp = new FundsSuccessResponse();
		resp.setRemarks("Funds Added Successfully");
		Mockito.when(userPortfolioService.addFunds("1", 2500)).thenReturn(resp);
		Assertions.assertNotNull(userPortfolioService.addFunds("1", 2500));
	}
}
