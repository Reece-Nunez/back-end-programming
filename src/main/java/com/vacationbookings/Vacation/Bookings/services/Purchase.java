package com.vacationbookings.Vacation.Bookings.services;

import com.vacationbookings.Vacation.Bookings.entities.Cart;
import com.vacationbookings.Vacation.Bookings.entities.CartItem;
import com.vacationbookings.Vacation.Bookings.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
