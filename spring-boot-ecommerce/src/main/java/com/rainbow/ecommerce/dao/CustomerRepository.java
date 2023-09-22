package com.rainbow.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rainbow.ecommerce.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByEmail(String theEmail);
}
