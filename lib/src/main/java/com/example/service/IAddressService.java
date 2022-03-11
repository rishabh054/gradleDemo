package com.example.service;

import java.util.List;

import com.example.bean.Address;

public interface IAddressService {
	Address addAddress(Address address);
	void deleteAddress(int id);
	Address updateAddress(Address address);
	Address getAddressById(int id);
	List<Address> getAllAddresses();

}