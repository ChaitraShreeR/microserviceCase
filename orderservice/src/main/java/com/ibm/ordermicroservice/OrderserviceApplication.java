package com.ibm.ordermicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ordermicroservice.service.OrderServices;

@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
public class OrderserviceApplication {

	@Autowired
	OrderServices orderService;
	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}

	@PostMapping(path="/order-microservice/add/{productName}/{productQty}/{userToken}/{transactiontoken}", produces = "application/json")
	public String addOrder(@PathVariable String productName, @PathVariable Integer productQty,
			@PathVariable String userToken,@PathVariable String transactiontoken) {

		return orderService.addProductOrder(productName,productQty,userToken,transactiontoken);
	}
	
	@GetMapping(path="/order-microservice")
	public String getMsg() {

		return "Testing.............";
	}
}
