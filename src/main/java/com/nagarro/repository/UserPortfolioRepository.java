package com.nagarro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.model.UserPortfolio;

@Repository
public interface UserPortfolioRepository extends JpaRepository<UserPortfolio, Long>{
	UserPortfolio findByUserId(String userId);
}
