package com.crud.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.model.Orders;
import com.crud.demo.repo.OrdersRepo;
import com.crud.demo.utils.OrdersErrorType;

@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersRepo ordersRepository;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Orders> getAll() {
		List<Orders> findAll = this.ordersRepository.findAll();
		return findAll;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> getById(@PathVariable("id") long id) {
		if (ordersRepository.findById(id).isPresent()) {
			return new ResponseEntity<Orders>(ordersRepository.findById(id).get(), HttpStatus.OK);
		}

		return new ResponseEntity(new OrdersErrorType("order with id " + id + " not found."), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Orders save(@RequestBody Orders json) {
		json.setOrderDate(new Date());
		Orders save = this.ordersRepository.save(json);
		return save;
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> update(@RequestBody Orders json) {
		long orderID = json.getOrderID();
		if (ordersRepository.findById(orderID).isPresent()) {
			Orders orders = this.ordersRepository.findById(orderID).get();
			orders.setOrderDate(new Date());
			Orders save = this.ordersRepository.save(orders);
			return new ResponseEntity<Orders>(save, HttpStatus.OK);
		}

		return new ResponseEntity(new OrdersErrorType("order with id " + orderID + " not found."),
				HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> delete(@PathVariable("id") long id) {
		if (ordersRepository.findById(id).isPresent()) {
			ordersRepository.deleteById(id);
			return new ResponseEntity<Orders>(HttpStatus.OK);

		}
		return new ResponseEntity(new OrdersErrorType("\"order with id " + id + " not found."), HttpStatus.OK);

	}

}
