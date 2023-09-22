package com.rainbow.ecommerce.dto;

import lombok.Data;

import java.util.Set;

import com.rainbow.ecommerce.entity.Address;
import com.rainbow.ecommerce.entity.Customer;
import com.rainbow.ecommerce.entity.Order;
import com.rainbow.ecommerce.entity.OrderItem;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
