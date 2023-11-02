package com.vacationbookings.Vacation.Bookings.controllers;


import com.vacationbookings.Vacation.Bookings.services.CheckoutService;
import com.vacationbookings.Vacation.Bookings.services.Purchase;
import com.vacationbookings.Vacation.Bookings.services.PurchaseResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin("http://localhost:4200")
public class CheckoutController {


    @Autowired
    private CheckoutService checkoutService;

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@Valid @RequestBody Purchase purchase) {

        PurchaseResponse savedPurchase = checkoutService.placeOrder(purchase);

        //PurchaseResponse purchaseResponse = new PurchaseResponse(savedPurchase.getCart().getOrderTrackingNumber());

        return savedPurchase;
    }


}

