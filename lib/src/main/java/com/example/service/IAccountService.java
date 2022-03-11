package com.example.service;

import com.example.bean.Account;

public interface IAccountService {
	
	Account addAccount(Account account);
	Account deleteAccount(Account account);
	Account updateAccount(Account account);
	Account getAccountById(int id);

}