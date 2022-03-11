package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.bean.Address;

public class AddressRepositoryImpl implements IAddressRepository{

	@Override
	public Address addAddress(Address address) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(address);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return address;
		
	}

	@Override
	public void deleteAddress(int id) {

		
	}

	@Override
	public Address updateAddress(Address address) {

		return null;
	}

	@Override
	public Address getAddressById(int id) {

		return null;
	}

	@Override
	public List<Address> getAllAddresses() {

		return null;
	}

}