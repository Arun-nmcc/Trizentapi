package com.Trizent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Trizent.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	List<Address> findByEmployeeId(int employffgfgfee_id);
	void deleteByEmployeeId(int employeeId);
	
}
