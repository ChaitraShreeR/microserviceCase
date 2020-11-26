package com.ibm.ordermicroservice.repository;

import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.ordermicroservice.entity.Order;

@Component
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
