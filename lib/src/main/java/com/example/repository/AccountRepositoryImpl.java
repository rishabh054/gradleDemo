package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.bean.Account;
import com.example.bean.Employee;

public class AccountRepositoryImpl implements IAccountRepository {

	@Override
	public Account addAccount(Account account) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(account);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return account;
		
	}

	@Override
	public Account deleteAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account updateAccount(Account account) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Get account by id
		Account dbAcc= em.find(Account.class, account.getId());
		
		// Update account by id
		dbAcc.setEmail(account.getEmail());
		dbAcc.setPassword(account.getPassword());
		
		// save employee with updated details
		em.merge(dbAcc);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return dbAcc;
	
	}

	@Override
	public Account getAccountById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		//sql query - select * from employee;
		Account acc = em.find(Account.class, id);
		//Account account= (Account)em.createQuery("select a from Account a where id=:accId").setParameter("accId", id).getSingleResult();
		
		em.close();
		emf.close();
		
		return acc;
		
	}

}