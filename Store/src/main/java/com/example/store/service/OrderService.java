package com.example.store.service;

import com.example.store.model.Order;
import com.example.store.model.Product;

import java.util.List;

public interface OrderService {
    Order createOrder(String name, String address, String payment, List<Product> products);
    List<Order> getOrders();
    String getSuccessMessage();
    String getErrorMessage();
}