package com.nagarro.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nagarro.model.Equity;
import com.nagarro.model.Holding;
import com.nagarro.model.Trade;
import com.nagarro.model.TradeResponse;
import com.nagarro.model.UserPortfolio;
import com.nagarro.service.TradeService;

class TradeControllerTest {

	@InjectMocks
	private TradeController tradeController;
	
	@Mock
	private TradeService tradeService;
	
	@Mock
	private TradeResponse tradeResponse;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldBuyEquityTest() {
		Trade testTrade = new Trade();
		testTrade.setQty(20);
		testTrade.setStockName("wipro");
		tradeResponse.setStatusCode(200);
		tradeResponse.setRemarks("Bought");
		Mockito.when(tradeService.buyEquity("1", testTrade)).thenReturn(tradeResponse);
		Assertions.assertEquals("Bought", tradeResponse.getRemarks());

		
	}
	
	

}
