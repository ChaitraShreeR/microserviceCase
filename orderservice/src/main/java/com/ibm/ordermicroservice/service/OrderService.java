package com.ibm.ordermicroservice.service;

public interface OrderService {

	public String addProductOrder(String productName,Integer productQty,String userToken,String transactionToken);
	public void LogOrderAudit(Integer OrderNo,String userToken,String transactionToken);
}
