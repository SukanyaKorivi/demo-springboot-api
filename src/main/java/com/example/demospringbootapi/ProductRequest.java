package com.example.demospringbootapi;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductRequest {
    @NotBlank
    private String name;
    @Positive
    private double price;
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
