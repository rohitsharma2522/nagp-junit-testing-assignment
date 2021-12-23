package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Equity;

@Repository
public interface EquityRepository extends JpaRepository<Equity, Long> {
	
	Equity findByName(String name);
}
