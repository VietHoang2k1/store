package com.example.store.service.impl;

import com.example.store.model.Category;
import com.example.store.model.Order;
import com.example.store.model.Product;
import com.example.store.repository.CategoryRepository;
import com.example.store.repository.OrderRepository;
import com.example.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    private String successMessage;
    private String errorMessage;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order createOrder(String name, String address, String payment, List<Product> products) {
        try {
            Order order = new Order();
            order.setCustomerName(name);
            order.setAddress(address);
            order.setPaymentMethod(payment);
            order.setDate(new Date());
            Set<Product> uniqueProducts = new HashSet<>(products);
            order.setProducts(new ArrayList<>(uniqueProducts));
            int total = uniqueProducts.stream()
                    .mapToInt(product -> product.getNewPrice() != null ? product.getNewPrice() : 0)
                    .sum();
            order.setTotal(total);
            Order savedOrder = orderRepository.save(order);
            successMessage = "Đơn hàng đã được tạo thành công!";
            return savedOrder;
        } catch (Exception e) {
            errorMessage = "Lỗi khi tạo đơn hàng: " + e.getMessage();
            throw new RuntimeException(errorMessage);
        }
    }
    @Override
    public String getSuccessMessage() {
        return successMessage;
    }
    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
