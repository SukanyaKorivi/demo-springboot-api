package com.example.demospringbootapi;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
  public Product createProduct(Product product){
     if(product.getPrice()>0)return product;
     else{
         throw new IllegalArgumentException("Price should be greater than 0");
     }
  }
}
