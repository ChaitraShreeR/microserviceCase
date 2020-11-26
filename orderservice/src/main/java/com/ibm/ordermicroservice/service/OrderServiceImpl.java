package com.ibm.ordermicroservice.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.ordermicroservice.entity.Order;
import com.ibm.ordermicroservice.entity.OrderAudit;
import com.ibm.ordermicroservice.repository.OrderAuditRepository;
import com.ibm.ordermicroservice.repository.OrderRepository;

@Service
public class OrderServiceImpl {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderAuditRepository orderAuditRepository;
	
	public String addProductOrder(String productName,Integer productQty,String userToken, String transactionToken){
		Order order = new Order();
		order.setProductName(productName);
		order.setProductQty(productQty);
		order = orderRepository.save(order);
		
		LogOrderAudit(order.getId(), userToken, transactionToken);
		return "Your product order has been placed successfully with Order Id :" + order.getId();
	
	}
	
	
	public void LogOrderAudit(Integer orderNo, String userToken, String transactionToken) {
		
		OrderAudit orderAudit = new OrderAudit();
		orderAudit.setOrderNo(orderNo);
		try {
			orderAudit.setUserToken(new javax.sql.rowset.serial.SerialClob(userToken.toCharArray()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		orderAudit.setTransactionToken(transactionToken);
		orderAuditRepository.save(orderAudit);
	}
}
