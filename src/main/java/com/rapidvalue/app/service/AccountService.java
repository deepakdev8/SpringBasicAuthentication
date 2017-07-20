package com.rapidvalue.app.service;

import java.util.List;

import com.rapidvalue.app.repository.entity.Account;

public interface AccountService {
	
	public List<Account> findAllAccounts();
	
	public Account createAccount(Account account);
	
	public Account updateAccount(Account account);
	
	public void deleteAccount(long id);
	
	public Account findAccountById(long id);
	
	public Account findAccountByAccountNumber(long accountNumber);
	

}
