package com.crud.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ProductID;
	private String ProductName;
	private long Price;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "products")
	private OrderDetails orderdetails;

	public Products() {
	}

	public Products(long productID, String productName, long price, OrderDetails orderdetails) {
		super();
		ProductID = productID;
		ProductName = productName;
		Price = price;
		this.orderdetails = orderdetails;
	}

	public long getProductID() {
		return ProductID;
	}

	public void setProductID(long productID) {
		ProductID = productID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}
}
