package com.example.repository;

import com.example.bean.Account;

public interface IAccountRepository {

	Account addAccount(Account account);
	Account deleteAccount(Account account);
	Account updateAccount(Account account);
	Account getAccountById(int id);
}