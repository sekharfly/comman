package com.crud.demo.controller;

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

import com.crud.demo.model.Products;
import com.crud.demo.repo.ProductsRepo;
import com.crud.demo.utils.ProductsErrorType;

@RestController
@RequestMapping("products")
public class ProductsController {
	@Autowired
	private ProductsRepo productsRepository;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Products> getAll() {
		List<Products> findAll = this.productsRepository.findAll();
		return findAll;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> getById(@PathVariable("id") long id) {
		if (productsRepository.findById(id).isPresent()) {
			return new ResponseEntity<Products>(productsRepository.findById(id).get(), HttpStatus.OK);
		}

		return new ResponseEntity(new ProductsErrorType("Product with id " + id + " not found."), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Products save(@RequestBody Products json) {
		Products save = this.productsRepository.save(json);
		return save;
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> update(@RequestBody Products json) {
		long productID = json.getProductID();
		if (productsRepository.findById(productID).isPresent()) {
			Products products = this.productsRepository.findById(productID).get();
			products.setProductName(json.getProductName());
			products.setPrice(json.getPrice());
			Products save = this.productsRepository.save(products);
			return new ResponseEntity<Products>(save, HttpStatus.OK);
		}

		return new ResponseEntity(new ProductsErrorType("Product with id " + productID + " not found."),
				HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> delete(@PathVariable("id") long id) {

		if (productsRepository.findById(id).isPresent()) {
			productsRepository.deleteById(id);
			return new ResponseEntity<Products>(HttpStatus.OK);
		}
		return new ResponseEntity(new ProductsErrorType("Product with id " + id + " not found."), HttpStatus.NOT_FOUND);

	}
}
