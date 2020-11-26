package com.ibm.ordermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ibm.ordermicroservice.entity.OrderAudit;

@Component
public interface OrderAuditRepository extends JpaRepository<OrderAudit, Integer>{

}
