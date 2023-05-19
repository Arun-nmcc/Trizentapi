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

import com.Trizent.model.Address;
import com.Trizent.service.AddressService;

@RestController
@RequestMapping("/Employee/{id}/Address")
public class AddressAPI {
	AddressService addressService ;
	public AddressAPI(AddressService addressService){
		this.addressService = addressService;
		
	}
	@PostMapping()
	public ResponseEntity<Address> saveAddress(@PathVariable("id") int id, @RequestBody Address address) {
		
		Address saveAddress = addressService.saveAddress(address,id);
		return new ResponseEntity<Address>(saveAddress,HttpStatus.CREATED);
	}
	@PutMapping("{AdID}")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") int id,
			                                      @PathVariable("AdID") int adid,
			                                       @RequestBody Address address){
		Address updateAddress = addressService.updateAddress(address, adid, id);
		return new ResponseEntity<Address>(updateAddress,HttpStatus.CREATED);
		
	}
	@DeleteMapping("{AdID}")
	public String deleteEmployeeById(@PathVariable("id") int id,
            @PathVariable("AdID") int adid){
		addressService.deleteAddress(adid, id);
		return "deleted succesfully";
		
	}
	@GetMapping
	public ResponseEntity<List<Address>> getAllAddress(@PathVariable("id") int id){
		List<Address> allAddresses = addressService.getAllAddresses(id);
		return new ResponseEntity<List<Address>>(allAddresses,HttpStatus.OK);
		
	}
	@GetMapping("{AdID}")
	public ResponseEntity<Address> getAddressById(@PathVariable("id") int id, @PathVariable("AdID") int adid){
		Address addressById = addressService.getAddressById(adid, id);
		return new ResponseEntity<Address>(addressById,HttpStatus.OK);
	}
	

}
