package com.example.service;

import com.example.bean.Account;
import com.example.bean.Employee;
import com.example.repository.AccountRepositoryImpl;
import com.example.repository.EmployeeRepositoryImpl;
import com.example.repository.IAccountRepository;
import com.example.repository.IEmployeeRepository;

public class AccountServiceImpl implements IAccountService{
	
	IAccountRepository accountRepo= new AccountRepositoryImpl();
	IEmployeeRepository empRepo = new EmployeeRepositoryImpl();
	
	@Override
	public Account addAccount(Account account) {
		Employee emp = account.getEmployee();
		empRepo.addEmployee(emp);
		return accountRepo.addAccount(account);
		
	}

	@Override
	public Account deleteAccount(Account account) {
		return accountRepo.deleteAccount(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountRepo.updateAccount(account);
	}

	@Override
	public Account getAccountById(int id) {
		return accountRepo.getAccountById(id);
	}

}