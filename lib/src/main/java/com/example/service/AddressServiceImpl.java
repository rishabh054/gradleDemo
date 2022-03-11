package com.example.service;

import java.util.List;

import com.example.bean.Address;
import com.example.repository.AddressRepositoryImpl;
import com.example.repository.IAddressRepository;

public class AddressServiceImpl implements IAddressService{
	IAddressRepository addrRepo= new AddressRepositoryImpl();

	@Override
	public Address addAddress(Address address) {
		return addrRepo.addAddress(address);
	}

	@Override
	public void deleteAddress(int id) {
		addrRepo.deleteAddress(id);
		
	}

	@Override
	public Address updateAddress(Address address) {
		return addrRepo.updateAddress(address);
	}

	@Override
	public Address getAddressById(int id) {
		return addrRepo.getAddressById(id);
	}

	@Override
	public List<Address> getAllAddresses() {
		return addrRepo.getAllAddresses();
	}
	
	

}