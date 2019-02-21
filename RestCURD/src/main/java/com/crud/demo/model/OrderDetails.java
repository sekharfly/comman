package com.crud.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class OrderDetails implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long OrderDetailID;
	private long Quantity;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Products products;

	public OrderDetails() {

	}

	public OrderDetails(long orderDetailID, long quantity, Products products) {
		super();
		OrderDetailID = orderDetailID;
		Quantity = quantity;
		this.products = products;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public long getOrderDetailID() {
		return OrderDetailID;
	}

	public void setOrderDetailID(long orderDetailID) {
		OrderDetailID = orderDetailID;
	}

	public long getQuantity() {
		return Quantity;
	}

	public void setQuantity(long quantity) {
		Quantity = quantity;
	}
}
