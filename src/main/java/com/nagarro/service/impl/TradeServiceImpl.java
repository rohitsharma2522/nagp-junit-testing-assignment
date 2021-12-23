package com.nagarro.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.model.Equity;
import com.nagarro.model.Holding;
import com.nagarro.model.Trade;
import com.nagarro.model.TradeResponse;
import com.nagarro.model.UserPortfolio;
import com.nagarro.service.EquityService;
import com.nagarro.service.TradeService;
import com.nagarro.service.UserPortfolioService;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	UserPortfolioService userPortfolioService;

	@Autowired
	EquityService equityService;

	@Override
	public TradeResponse buyEquity(String userId, Trade tradedetails) {
		// check if user and equity is present

		TradeResponse tradeResponse = new TradeResponse();
		UserPortfolio userDetails = userPortfolioService.getUserByUserId(userId);
		Equity equityDetails = equityService.getEquityByName(tradedetails.getStockName());
		if (equityDetails != null) {
			tradeResponse.setStatusCode(400);
			tradeResponse.setRemarks("User/Equity Not Found");
			return tradeResponse;

		}
		// if sufficent balance

		double balance = userDetails.getBalance();
		if (balance > tradedetails.getQty() * equityDetails.getCurrentPrice()) {
			Holding holdingsDetails = new Holding();
			holdingsDetails.setEquities(equityDetails);
			holdingsDetails.setQty(tradedetails.getQty());
			userDetails.setHoldings((List<Holding>) holdingsDetails);
			tradeResponse.setStatusCode(200);
			tradeResponse.setRemarks("Equity Bought Successfully");
		} else {
			tradeResponse.setStatusCode(200);
			tradeResponse.setRemarks("Insufficent Balance");
		}
		return tradeResponse;

	}

	@Override
	public TradeResponse sellEquity(String userId, Trade tradedetails) {
		UserPortfolio userDetails = userPortfolioService.getUserByUserId(userId);
		// check holding exits
		TradeResponse tr = new TradeResponse();
		List<Holding> updatedHoldings = new ArrayList<Holding>();
		for (Holding h : userDetails.getHoldings()) {
			Equity equities = h.getEquities();

			if (equities.getStockName().equals(tradedetails.getStockName()) && h.getQty() >= tradedetails.getQty()) {
				Holding holding = new Holding();
				Equity eq = new Equity();
				eq.setStockName(tradedetails.getStockName());
				if (h.getQty() - tradedetails.getQty() == 0.0) {
					userDetails.getHoldings().remove(h);
				} else {
					holding.setEquities(eq);
					holding.setQty(h.getQty() - tradedetails.getQty());
					updatedHoldings.add(holding);
					userDetails.setHoldings(updatedHoldings);
				}
				tr.setRemarks("Holding sold successfully");
				tr.setStatusCode(200);

			} else if (h.getQty() < tradedetails.getQty()) {
				tr.setRemarks("Invalid Holdings value");
				tr.setStatusCode(200);
			}
		}
		return tr;

	}
}
