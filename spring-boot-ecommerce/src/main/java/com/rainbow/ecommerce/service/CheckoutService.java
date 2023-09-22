package com.rainbow.ecommerce.service;

import com.rainbow.ecommerce.dto.PaymentInfo;
import com.rainbow.ecommerce.dto.Purchase;
import com.rainbow.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
	
	 PurchaseResponse placeOrder(Purchase purchase);
	 
	
	    public PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
	 
}
