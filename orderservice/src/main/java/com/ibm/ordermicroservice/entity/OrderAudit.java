package com.ibm.ordermicroservice.entity;

import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="order_audit")
public class OrderAudit {

	@Id
	@SequenceGenerator(name= "ORDER_AUDIT_SEQUENCE", sequenceName = "ORDER_AUDIT_SEQUENCE_ID", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="ORDER_AUDIT_SEQUENCE")
	Integer id;
	Integer OrderNo;
	Clob userToken;
	String transactionToken;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(Integer orderNo) {
		OrderNo = orderNo;
	}

	public Clob getUserToken() {
		return userToken;
	}
	public void setUserToken(Clob userToken) {
		this.userToken = userToken;
	}
	public String getTransactionToken() {
		return transactionToken;
	}
	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
	}
	

}
