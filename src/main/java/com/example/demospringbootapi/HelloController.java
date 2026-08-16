package com.example.demospringbootapi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
public String hello(@RequestParam String name){
    return "Hello "+name +" hope you are doing well.Be strong!";
}


@GetMapping("/products")
public Product product(){
    return new Product(1,"laptop",50000);
}


private final ProductService productService;
@PostMapping("/products")
public Product createProduct(@RequestBody Product product){
   return productService.createProduct(product);
}


public HelloController(ProductService p){
this.productService=p;
}


@ExceptionHandler(IllegalArgumentException.class)
public ResponseEntity<String> handleInvalidProduct(IllegalArgumentException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
}
}

