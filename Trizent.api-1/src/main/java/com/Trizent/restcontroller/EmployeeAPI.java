package com.Trizent.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Trizent.model.Employee;
import com.Trizent.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Employee")
public class EmployeeAPI {
	private EmployeeService employeeService;

	public EmployeeAPI(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = employeeService.getAllEmployees();

		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody@Valid Employee employee) {
		Employee saveEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(saveEmployee, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
		Employee employeeById = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<Employee>(employeeById, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody@Valid Employee employee) {
		Employee updateEmployee = employeeService.updateEmployee(employee, id);
		return new ResponseEntity<Employee>(updateEmployee, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

		employeeService.deleteEmployee(id);

		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	

}
