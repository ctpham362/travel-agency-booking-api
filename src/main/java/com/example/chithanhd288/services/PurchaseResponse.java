package com.example.chithanhd288.services;

import lombok.Data;

@Data

public class PurchaseResponse {
    private final String orderTrackingNumber;
    private String message;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
        this.message = "Creation Successful";
    }
}
