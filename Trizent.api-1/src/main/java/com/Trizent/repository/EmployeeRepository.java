package com.Trizent.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Trizent.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByEmail(String email);

	List<Employee> findBySexAndNameStartingWith(String sex, String nameStartsWith);

	List<Employee> findBySex(String sex);

	List<Employee> findByNameStartingWith(String namePrefix);

}