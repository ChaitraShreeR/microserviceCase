package com.ibm.ordermicroservice.service;

import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Service;



public interface OrderServices {

	public String addProductOrder(String productName,Integer productQty,String userToken,String transactionToken);
	public void LogOrderAudit(Integer OrderNo,String userToken,String transactionToken);
}
