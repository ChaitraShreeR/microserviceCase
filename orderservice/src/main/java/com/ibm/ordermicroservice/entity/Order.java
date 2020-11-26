package com.ibm.ordermicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="product_order_details")
public class Order {

	@Id
	@SequenceGenerator(name= "ORDER_SEQUENCE", sequenceName = "ORDER_SEQUENCE_ID", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="ORDER_SEQUENCE")
	
	Integer id;

	String productName;
	Integer productQty;

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductQty() {
		return productQty;
	}
	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
