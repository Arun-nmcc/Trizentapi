package com.Trizent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Trizent.exceptions.DataNotFoundException;
import com.Trizent.exceptions.DuplicateEmailException;
import com.Trizent.model.Address;
import com.Trizent.model.Employee;
import com.Trizent.repository.AddressRepository;
import com.Trizent.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private AddressRepository addressRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.addressRepository = addressRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Optional<Employee> findByEmail = employeeRepository.findByEmail(employee.getEmail());
		if (findByEmail.isPresent()) {
			throw new DuplicateEmailException("Email already exist");
		}

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees(String sex, String nameStartsWith) {
		if (sex != null && nameStartsWith != null) {
			return employeeRepository.findBySexAndNameStartingWith(sex, nameStartsWith);
		} else if (sex != null) {
			return employeeRepository.findBySex(sex);
		} else if (nameStartsWith != null) {
			return employeeRepository.findByNameStartingWith(nameStartsWith);
		} else {
			return employeeRepository.findAll();
		}

	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else
			throw new DataNotFoundException("data not found exception");

	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Optional<Employee> findById1 = employeeRepository.findById(id);
		if (findById1.isPresent()) {

			Employee employee2 = findById1.get();
			if (employee2.getEmail().equals(employee.getEmail())) {
			} else {
				Optional<Employee> findByEmail = employeeRepository.findByEmail(employee.getEmail());
				if (findByEmail.isPresent())

					throw new DuplicateEmailException("email already exist");

			}

		}

		Optional<Employee> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {

			Employee employee2 = findById.get();

			employee2.setName(employee.getName());
			employee2.setPhone(employee.getPhone());
			employee2.setEmail(employee.getEmail());
			// System.out.println(employee2.getPhone());

			employeeRepository.save(employee2);
			return employee2;
		}
		throw new DataNotFoundException("data not found exception");
	}

	@Override
	public void deleteEmployee(long id) {

		Optional<Employee> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {
			 Employee employee = findById.get();
		        List<Address> addresses = employee.getAddress();
		        
		     
		        addressRepository.deleteAll(addresses);
			
			employeeRepository.deleteById(id);
		}else
		throw new DataNotFoundException("data not found exception");

	}
}
