package com.example.store.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "address")
    private String address;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @Column(name = "total")
    private Integer total;

    @Column(name = "date")
    private Date date;

    // Định nghĩa ManyToMany với bảng trung gian orders_products
    @ManyToMany
    @JoinTable(
            name = "orders_products", // tên của bảng trung gian
            joinColumns = @JoinColumn(name = "order_id"), // khóa ngoại đến bảng Order
            inverseJoinColumns = @JoinColumn(name = "id") // khóa ngoại đến bảng Product
    )
    private List<Product> products;
}