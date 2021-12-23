package com.nagarro.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.model.Equity;

@Service
public interface EquityService {
	public Equity addEquity(Equity equityDetails);
	public List<Equity> getAllEquities();
	public Equity getEquityByName(String name);
	
}
