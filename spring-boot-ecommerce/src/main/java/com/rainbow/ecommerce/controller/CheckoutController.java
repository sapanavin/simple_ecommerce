package com.rainbow.ecommerce.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rainbow.ecommerce.dto.PaymentInfo;
import com.rainbow.ecommerce.dto.Purchase;
import com.rainbow.ecommerce.dto.PurchaseResponse;
import com.rainbow.ecommerce.service.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;


@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
//@Autowired(required=true)
    private CheckoutService checkoutService;

    public CheckoutController(@Autowired(required=true) CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException {

    	logger.info("paymentInfo.amount: "+paymentInfo.getAmount());
        PaymentIntent paymentIntent = checkoutService.createPaymentIntent(paymentInfo);

        String paymentStr = paymentIntent.toJson();

        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }
}









