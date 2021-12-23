package com.nagarro.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nagarro.model.Equity;
import com.nagarro.service.EquityService;

@RunWith(MockitoJUnitRunner.class)
class EquityControllerTest {

	@InjectMocks
	private EquityController equityController;
	
	@Mock
	private EquityService equityService;
	
	@Mock
	private Equity equity;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldGetAllEntitiesTest() {
		Equity testEquity = new Equity("reliance", 2000);
		Equity testEquity2 = new Equity("wipro", 500);
		List<Equity> equityList = new ArrayList<>();
		equityList.add(testEquity);
		equityList.add(testEquity2);
		Mockito.when(equityService.getAllEquities()).thenReturn(equityList);
		Assertions.assertEquals(2, equityController.getAllEquities().size());
	}
	
	@Test
	public void shouldGetByNameTest() {
		
		Mockito.when(equityService.getEquityByName("wipro")).thenReturn(equity);
		Assertions.assertNotNull(equityController.getEquityByName("wipro"));
	}
	@Test
	 public void shouldCreateNewEquity(){
	     Equity equitydata = new Equity("tatamotors",400.50);
	     Mockito.when(equityService.addEquity(equity)).thenReturn(equitydata);
	     Assertions.assertEquals(equitydata.getEid(),equityController.createEquity(equitydata).getEid());
	 }
	
	 @Test
	 public void shouldNotAddEquity() throws Exception{
	     Equity equitydata = new Equity("abc",10.0);
	     Mockito.when(equityService.addEquity(equitydata)).thenReturn(null);
	     Assertions.assertEquals(null,equityController.createEquity(equitydata));
	 }


	@Test
	public void shouldNotReturnEquityForEmptyName() {
		Assertions.assertNull(equityController.getEquityByName(null));
	}

}
