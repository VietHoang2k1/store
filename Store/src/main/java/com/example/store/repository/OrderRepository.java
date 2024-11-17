package com.example.store.repository;

import com.example.store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // JpaRepository cung cấp sẵn các phương thức CRUD, không cần phải tự viết thêm.
}