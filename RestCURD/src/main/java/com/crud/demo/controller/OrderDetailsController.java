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

import com.crud.demo.model.OrderDetails;
import com.crud.demo.repo.OrderDetailsRepo;
import com.crud.demo.utils.OrderDetailsErrorType;

@RestController
@RequestMapping("orderdetails")
public class OrderDetailsController {
	@Autowired
	private OrderDetailsRepo orderDetailsRepository;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDetails> getOrderDetails() {
		List<OrderDetails> findAll = this.orderDetailsRepository.findAll();
		return findAll;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDetails> getOrderDetailsById(@PathVariable("id") long id) {
		if (orderDetailsRepository.findById(id) == null) {

			return new ResponseEntity<OrderDetails>(orderDetailsRepository.findById(id).get(), HttpStatus.OK);
		}
		return new ResponseEntity(new OrderDetailsErrorType("OrderDetails with id " + id + " not found."),
				HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDetails saveOrderDetails(@RequestBody OrderDetails json) {
		OrderDetails save = this.orderDetailsRepository.save(json);
		return save;
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDetails> updateCustomers(@RequestBody OrderDetails json) {
		long orderDetailID = json.getOrderDetailID();
		if (orderDetailsRepository.findById(orderDetailID).isPresent()) {
			Optional<OrderDetails> findById = this.orderDetailsRepository.findById(orderDetailID);
			OrderDetails orderDetails = findById.get();
			orderDetails.setOrderDetailID(json.getOrderDetailID());
			orderDetails.setQuantity(json.getQuantity());
			return new ResponseEntity<OrderDetails>(orderDetailsRepository.save(orderDetails), HttpStatus.OK);
		}
		return new ResponseEntity(new OrderDetailsErrorType("Orderdetails with id " + orderDetailID + " not found."),
				HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDetails> deleteOrderDetails(@PathVariable("id") long id) {

		if (orderDetailsRepository.findById(id).isPresent()) {

			return new ResponseEntity<OrderDetails>(HttpStatus.OK);
		}
		return new ResponseEntity(new OrderDetailsErrorType("Orderdetails with id " + id + " not found."),
				HttpStatus.NOT_FOUND);

	}

}
