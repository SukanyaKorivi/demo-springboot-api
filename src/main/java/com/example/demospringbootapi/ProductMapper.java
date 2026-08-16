package com.example.demospringbootapi;

public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return new Product(
                0,
                request.getName(),
                request.getPrice()
        );
    }

    public ProductResponse toResponse(Product product) {

        ProductResponse response = new ProductResponse();

        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());

        return response;
    }}
