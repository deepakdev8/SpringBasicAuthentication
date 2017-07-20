package com.rapidvalue.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.rapidvalue.app.repository.entity.Account;


public interface AccountsDao extends CrudRepository<Account, Long> {
	
	public Account findByAccountNumber(long accountNumber);
	
}