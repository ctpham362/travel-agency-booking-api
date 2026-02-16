package com.example.chithanhd288.controllers;

import com.example.chithanhd288.services.CheckoutService;
import com.example.chithanhd288.services.Purchase;
import com.example.chithanhd288.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")

public class CheckoutController {
    private final CheckoutService checkoutService;
    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
