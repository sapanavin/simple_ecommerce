package com.rainbow.ecommerce.dao;

import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainbow.ecommerce.entity.Order;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

	
	//@GetMapping("/findByCustomerEmail")
    Page<Order> findByCustomerEmailOrderByDateCreatedDesc(@Param("email") String email, Pageable pageable);
    //List<Order> findByCustomerEmail(@Param("email") String email);
    
    //Page<Order> findByCustomerEmail(@Param("email") String email, Pageable pageable);
   // findByCustomerEmailOrderByDateCreatedDesc

}
