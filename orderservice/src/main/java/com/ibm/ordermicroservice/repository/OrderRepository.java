package com.ibm.ordermicroservice.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ibm.ordermicroservice.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
