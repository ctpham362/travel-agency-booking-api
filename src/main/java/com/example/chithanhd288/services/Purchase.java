package com.example.chithanhd288.services;

import com.example.chithanhd288.entities.CartItem;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import com.example.chithanhd288.entities.*;

@Getter
@Setter

public class Purchase {
    Customer customer;
    Cart cart;
    Set<CartItem> cartItems;
}
