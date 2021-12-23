package com.nagarro.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nagarro.controller.TradeController;
import com.nagarro.model.Equity;
import com.nagarro.model.Holding;
import com.nagarro.model.Trade;
import com.nagarro.model.TradeResponse;
import com.nagarro.model.UserPortfolio;

class TradeServiceTest {

	@Mock
	private TradeService tradeService;
	
	@Mock
	private UserPortfolioService userPortfolioService ;
	
	@Mock
	private EquityService equityService ;
	
	@Mock
	private TradeController tradeController;
	
	@Mock
	private TradeResponse TradeResponse;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void shouldBuyEquityTest() {
		List<Holding> holdingList = new ArrayList<Holding>();
		Equity eq  = new Equity("reliance", 2000);
		Holding holding = new Holding(eq, 200);
		Trade tradeDetails = new Trade("reliance", 100);
		holdingList.add(holding);
		UserPortfolio up = new UserPortfolio("1", 4000, holdingList);
		TradeResponse resp = new TradeResponse();
		resp.setStatusCode(200);
		resp.setRemarks("Bought Successfully");
		Mockito.when(userPortfolioService.getUserByUserId("1")).thenReturn(up);
		Mockito.when(equityService.getEquityByName("reliance")).thenReturn(eq);
		Assertions.assertNotNull(tradeService.buyEquity("1", tradeDetails));
		
	}
	
	@Test
	public void shouldSellEquityTest() {
		List<Holding> holdingList = new ArrayList<Holding>();
		Equity eq  = new Equity("reliance", 2000);
		Holding holding = new Holding(eq, 200);
		Trade tradeDetails = new Trade("reliance", 100);
		holdingList.add(holding);
		UserPortfolio up = new UserPortfolio("1", 4000, holdingList);
		Mockito.when(userPortfolioService.getUserByUserId("1")).thenReturn(up);
		Mockito.when(equityService.getEquityByName("reliance")).thenReturn(eq);
		Assertions.assertNotNull(tradeService.sellEquity("1", tradeDetails));
		
	}

}
