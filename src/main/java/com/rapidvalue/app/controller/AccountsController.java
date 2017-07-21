package com.rapidvalue.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rapidvalue.app.model.AccountRequest;
import com.rapidvalue.app.repository.entity.Account;
import com.rapidvalue.app.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountsController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/accounts", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> listAllAccounts(){
		List<Account> accounts = accountService.findAllAccounts();
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}
	
	@RequestMapping(value="/accounts", method = RequestMethod.POST)
	public ResponseEntity<Account> createAccount(@RequestBody AccountRequest accountRequest){
		Account createAccount = new Account();
		createAccount.setAccountNumber(accountRequest.getAccountNumber());
		createAccount.setOwner(accountRequest.getOwnerName());
		Account createdAccount = accountService.createAccount(createAccount);
		return new ResponseEntity<Account>(createdAccount, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/accounts/{id}", method = RequestMethod.GET)
	public ResponseEntity<Account> findAccountById(@PathVariable long id){
		Account account = accountService.findAccountById(id);
		return new ResponseEntity<Account>(account,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/accounts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAccount(@PathVariable long id){
		accountService.deleteAccount(id);
		return new ResponseEntity<String >("Deleted",HttpStatus.OK);	
	}
	
	
}
