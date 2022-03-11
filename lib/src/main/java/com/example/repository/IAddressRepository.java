package com.example.repository;

import java.util.List;

import com.example.bean.Address;

public interface IAddressRepository {

	Address addAddress(Address address);
	void deleteAddress(int id);
	Address updateAddress(Address address);
	Address getAddressById(int id);
	List<Address> getAllAddresses();

}