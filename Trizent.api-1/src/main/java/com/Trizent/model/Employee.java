package com.Trizent.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
@Entity
@Table(name = "employee")
public class Employee {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;
	 @Column(name ="age")
	 private int age;
	 @Column(name ="sex")
	 private String sex;

	    public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
		@Column(name = "name")
	    private String name;
		@Email(regexp = "^[A-Za-z0-9._%+-]+@trizent\\.com$", message = "Please enter a valid email address ending with @trizent.com")
	
	    @Column(name = "email")
	    private String email;
		@Digits(integer = 10, fraction = 0, message = "Phone number must be a valid numeric value")
	    @Column(name = "phone")
	    private long phone;

	    @OneToMany( mappedBy = "employee")
	   
	    private List<Address> addresses;
	 
	   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	} @JsonIgnore
	public List<Address> getAddress() {
		return addresses;
	}
	public void setAddress(List<Address> address) {
		this.addresses = address;
	}
	

}
