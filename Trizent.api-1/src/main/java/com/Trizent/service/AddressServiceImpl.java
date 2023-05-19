package com.Trizent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Trizent.exceptions.DataNotFoundException;
import com.Trizent.model.Address;
import com.Trizent.model.Employee;
import com.Trizent.repository.AddressRepository;
import com.Trizent.repository.EmployeeRepository;

@Service
public class AddressServiceImpl implements AddressService {

	private EmployeeRepository employeeRepository;
	private AddressRepository addressRepository;

	public AddressServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.addressRepository = addressRepository;
	}

	@Override
	public Address saveAddress(Address address, int employeeId) {
		Optional<Employee> employee = employeeRepository.findById((long) employeeId);
		if (employee.isPresent()) {
			address.setEmployee(employee.get());
			address.setEmployeeId(employeeId);
			addressRepository.save(address);
			return address;
		}
		throw new DataNotFoundException("data not found exception");

	}

	@Override
	public List<Address> getAllAddresses(int id) {
		Optional<Employee> employee = employeeRepository.findById((long) id);
		if (employee.isPresent()) {
			List<Address> findByEmployeeId = addressRepository.findByEmployeeId(id);
			return findByEmployeeId;
		}
		throw new DataNotFoundException("data not found exception");

	}

	@Override
	public Address getAddressById(long id, int employeeId) {
		Optional<Employee> employee = employeeRepository.findById((long) id);
		if (employee.isPresent()) {
			Optional<Address> findById = addressRepository.findById((int) id);
			if (findById.isPresent()) {
				return findById.get();
			}
			throw new DataNotFoundException("data not found exception");

		}
		throw new DataNotFoundException("data not found exception");

	}

	@Override
	public Address updateAddress(Address address, long id, int employeeId) {
		Optional<Employee> employee = employeeRepository.findById((long) employeeId);
		if (employee.isPresent()) {
			Optional<Address> findById = addressRepository.findById((int) id);
			if (findById.isPresent()) {
				Address address2 = findById.get();
				address2.setAddressType(address.getAddressType());
				address2.setCity(address.getCity());
				address2.setCountry(address.getCountry());
				address2.setEmployeeId(employeeId);
				address2.setLine1(address.getLine1());
				address2.setLine2(address.getLine2());
				address2.setState(address.getState());
				address2.setZipcode(employeeId);
				addressRepository.save(address2);
				return address2;
			}
			throw new DataNotFoundException("data not found exception");

		}

		throw new DataNotFoundException("data not found exception");

	}

	@Override
	public void deleteAddress(long id, int employeeId) {
		Optional<Employee> employee = employeeRepository.findById((long) employeeId);
		if (employee.isPresent()) {
			Optional<Address> findById = addressRepository.findById((int) id);
			if (findById.isPresent()) {
				addressRepository.deleteById((int) id);

			}
			throw new DataNotFoundException("data not found exception");

		}
		throw new DataNotFoundException("data not found exception");

	}

}
