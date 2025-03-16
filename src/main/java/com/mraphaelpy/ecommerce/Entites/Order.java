package com.mraphaelpy.ecommerce.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;
}
