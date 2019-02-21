package com.crud.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.model.Customer;
import com.crud.demo.repo.CustomerRepo;
import com.crud.demo.utils.CustomErrorType;

@RestController
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepository;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomers() {
		List<Customer> findAll = this.customerRepository.findAll();
		return findAll;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomersById(@PathVariable("id") long id) {
		if (customerRepository.findById(id).isPresent()) {

			return new ResponseEntity<Customer>(customerRepository.findById(id).get(), HttpStatus.OK);
		}
		return new ResponseEntity(new CustomErrorType("User with id " + id + " not found."), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer saveCustomers(@RequestBody Customer json) {
		Customer save = this.customerRepository.save(json);
		return save;

	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomers(@RequestBody Customer json) {
		long customerID = json.getCustomerID();
		if (customerRepository.findById(customerID).isPresent()) {
			Optional<Customer> findById = this.customerRepository.findById(customerID);
			Customer customer = findById.get();
			customer.setAddress(json.getAddress());
			customer.setContactName(json.getContactName());
			customer.setCustomerName(json.getCustomerName());
			return new ResponseEntity<Customer>(customerRepository.save(customer), HttpStatus.OK);
		}
		return new ResponseEntity(new CustomErrorType("User with id " + customerID + " not found."), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> deleteCustomers(@PathVariable("id") long id) {

		if (customerRepository.findById(id).isPresent()) {

			return new ResponseEntity<Customer>(HttpStatus.OK);
		}
		return new ResponseEntity(new CustomErrorType("User with id " + id + " not found."), HttpStatus.NOT_FOUND);

	}
}
