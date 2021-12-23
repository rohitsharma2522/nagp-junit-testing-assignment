package com.nagarro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.model.Equity;
import com.nagarro.repository.EquityRepository;
import com.nagarro.service.EquityService;

@Service
public class EquityServiceImpl implements EquityService {

	@Autowired
	private EquityRepository equityRepository;


	@Override
	public Equity addEquity(Equity equityDetails) {
		try {
		      Equity equity = equityRepository
		          .save(new Equity(equityDetails.getStockName(), equityDetails.getCurrentPrice()));
		      return equity;
		    } catch (Exception e) {
		      return null;
		    }
	}

	@Override
	public List<Equity> getAllEquities() {
		try {
		      List<Equity> equityList = new ArrayList<Equity>();

		      equityRepository.findAll().forEach(equityList::add);
		      return equityList;
		  

		    } catch (Exception e) {
		      return null;
		    }
	}

	@Override
	public Equity getEquityByName(String name) {
		 Equity equityData = equityRepository.findByName(name);

		    if (equityData != null) {
		      return equityData;
		    } else {
		      return null;
		    }
	}
	
}
