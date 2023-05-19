package com.Trizent.service;

import java.util.List;

import com.Trizent.model.Address;

public interface AddressService {
	Address saveAddress(Address address, int employeeId);
	List<Address> getAllAddresses(int id);
	Address getAddressById(long id,int employeeId);
	Address updateAddress(Address address, long id,int employeeId);
	void deleteAddress(long id,int employeeId);
	
}
