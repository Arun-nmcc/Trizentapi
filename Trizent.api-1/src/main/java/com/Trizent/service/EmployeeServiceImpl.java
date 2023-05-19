package com.Trizent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Trizent.exceptions.DataNotFoundException;
import com.Trizent.exceptions.DuplicateEmailException;
import com.Trizent.model.Employee;
import com.Trizent.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
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
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();

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
			employeeRepository.deleteById(id);
		}
		throw new DataNotFoundException("data not found exception");

	}

}
