package com.mraphaelpy.ecommerce.Entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Setter
@Getter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String name;
    private double price;
    private int stock;

    @Version
    private Integer version;

    @ManyToOne
    private Category category;

}
