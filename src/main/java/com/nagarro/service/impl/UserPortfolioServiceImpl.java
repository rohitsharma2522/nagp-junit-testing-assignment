package com.nagarro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.FundsSuccessResponse;
import com.nagarro.model.UserPortfolio;
import com.nagarro.repository.UserPortfolioRepository;
import com.nagarro.service.UserPortfolioService;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

	@Autowired
	UserPortfolioRepository userPortfolioRepository;
	
	FundsSuccessResponse fundsResponse = new FundsSuccessResponse();

	@Override
	public UserPortfolio createUser(UserPortfolio userData) {
		try {
			UserPortfolio userPortfolio = userPortfolioRepository
		          .save(new UserPortfolio(userData.getUserId(), 0, null));
		     return userPortfolio;
		    } catch (Exception e) {
		      return null;
		    }
	}

	@Override
	public UserPortfolio getUserByUserId(String userId) {
		UserPortfolio portfolioData = userPortfolioRepository.findByUserId(userId);

		if (portfolioData != null) {
			return portfolioData;
		} else {
			return null;
		}
	}

	@Override
	public FundsSuccessResponse addFunds(String userId, double funds) {
		UserPortfolio userByUserId = getUserByUserId(userId);
		userByUserId.setBalance(funds);
		fundsResponse.setRemarks("Funds Added Successfully");
		return fundsResponse;
	}

}
