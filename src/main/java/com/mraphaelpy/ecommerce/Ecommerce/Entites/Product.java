package com.mraphaelpy.ecommerce.Ecommerce.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Setter
@Getter
public class Product {
    @Id
    private Long id;
    private String name;
    private double price;
    private int stock;

}
