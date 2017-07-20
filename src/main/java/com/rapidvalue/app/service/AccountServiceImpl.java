package com.rapidvalue.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapidvalue.app.repository.AccountsDao;
import com.rapidvalue.app.repository.entity.Account;

@Service("AccountService")
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountsDao accountsDao;
	
	@Override
	public List<Account> findAllAccounts() {
		return (List<Account>) accountsDao.findAll();
	}

	@Override
	public Account createAccount(Account account) {
		return accountsDao.save(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountsDao.save(account);
	}

	@Override
	public void deleteAccount(long id) {
		accountsDao.delete(findAccountById(id));
	}

	@Override
	public Account findAccountById(long id) {
		return accountsDao.findOne(id);
	}

	@Override
	public Account findAccountByAccountNumber(long accountNumber) {
		return accountsDao.findByAccountNumber(accountNumber);
	}

}
