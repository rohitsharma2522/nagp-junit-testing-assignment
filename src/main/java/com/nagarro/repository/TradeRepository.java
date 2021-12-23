package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>{

}
