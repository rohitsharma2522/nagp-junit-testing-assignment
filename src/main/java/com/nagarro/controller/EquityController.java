package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.model.Equity;
import com.nagarro.service.EquityService;

@Controller
public class EquityController {

	@Autowired
	EquityService equityService;
	
	@GetMapping("/equities")
	  public List<Equity> getAllEquities() {
		
		return equityService.getAllEquities();
	
	}
	
	@PostMapping("/equity")
	  public Equity createEquity(@RequestBody Equity equity) {
		return equityService.addEquity(equity);
	}
	
	@GetMapping("/equity/{name}")
	  public Equity getEquityByName(@PathVariable("name") String name) {
		if(name == null) return null;
		return equityService.getEquityByName(name);
	
	}

}
