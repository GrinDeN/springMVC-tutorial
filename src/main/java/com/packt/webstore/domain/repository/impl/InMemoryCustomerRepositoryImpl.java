package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepositoryImpl implements CustomerRepository {
	
	private List<Customer> customerList = new ArrayList<Customer>();
	
	public InMemoryCustomerRepositoryImpl() {
		Customer Andy = new Customer("C1", "Andy", "Warsaw");
		Customer John = new Customer("C2", "John", "London");
		Customer Margaret = new Customer("C3", "Margaret", "New York");
		
		customerList.add(Andy);
		customerList.add(John);
		customerList.add(Margaret);
	}

	public List<Customer> getAllCustomers() {
		return this.customerList;
	}

}
