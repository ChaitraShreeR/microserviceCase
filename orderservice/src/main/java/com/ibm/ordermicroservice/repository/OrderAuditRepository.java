package com.ibm.ordermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ibm.ordermicroservice.entity.OrderAudit;

@Repository
public interface OrderAuditRepository extends JpaRepository<OrderAudit, Integer>{

}
