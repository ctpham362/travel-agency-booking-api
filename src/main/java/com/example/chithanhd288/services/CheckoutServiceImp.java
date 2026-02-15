package com.example.chithanhd288.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.chithanhd288.entities.*;
import com.example.chithanhd288.dao.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Service

public class CheckoutServiceImp implements CheckoutService {
    private CartItemRepository cartItemRepository;
    private CartRepository cartRepository;
    private CustomerRepository customerRepository;
    private ExcursionRepository excursionRepository;
    private VacationRepository vacationRepository;

    @Autowired
    public CheckoutServiceImp(CartItemRepository cartItemRepository, CartRepository cartRepository, CustomerRepository customerRepository, ExcursionRepository excursionRepository, VacationRepository vacationRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.excursionRepository = excursionRepository;
        this.vacationRepository = vacationRepository;
    }

    @Override
    @Transactional

    public PurchaseResponse placeOrder(Purchase purchase) {
        Customer customer = purchase.getCustomer();
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();

        String trackingNumber = generateTrackingNumber();
        cart.setStatus(StatusType.ordered);

        LocalDateTime now = LocalDateTime.now();

        cart.setCreate_date(now);
        cart.setLast_update(now);

        cart.setCustomer(customer);

        for  (CartItem item : cartItems) {
            item.setCart(cart);
            item.setCreate_date(now);
            item.setLast_update(now);
        }
        cart.setCart_items(cartItems);

        if (customer.getId() == null) {
            customer.setCreate_date(now);
            customer.setLast_update(now);
            customerRepository.save(customer);
        }
        cartRepository.save(cart);
        return new PurchaseResponse(trackingNumber);
    }
    private String generateTrackingNumber() {
        return UUID.randomUUID().toString();
    }

}
