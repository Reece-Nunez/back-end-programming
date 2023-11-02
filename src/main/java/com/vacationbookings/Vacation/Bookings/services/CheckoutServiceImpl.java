package com.vacationbookings.Vacation.Bookings.services;

import com.vacationbookings.Vacation.Bookings.dao.CartItemRepository;
import com.vacationbookings.Vacation.Bookings.dao.CartRepository;
import com.vacationbookings.Vacation.Bookings.entities.Cart;
import com.vacationbookings.Vacation.Bookings.entities.CartItem;
import com.vacationbookings.Vacation.Bookings.entities.Customer;
import com.vacationbookings.Vacation.Bookings.entities.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();


        //cart.setId(cartId);
        String orderTrackingNumber = UUID.randomUUID().toString();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);
        cartItems.forEach(cartItem -> {
            cart.add(cartItem);
            cartItem.setCart(cart);
            //cartItemRepository.save(cartItem);
        });
        //customerRepository.save(customer);
        cartRepository.save(cart);
        //cartItemRepository.saveAll(cartItems);

        return new PurchaseResponse(orderTrackingNumber);
    }
}
