package com.example.demospringbootapi;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public Product createProduct(@Valid @RequestBody Product product){

    return productService.createProduct(product);
}


public HelloController(ProductService p){
this.productService=p;
}


@ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Map<String,String>> handleInvalidEntries(MethodArgumentNotValidException e){
    List<FieldError> errors = e.getBindingResult().getFieldErrors();

    Map<String,String> errorlist =new HashMap<>();
    for(FieldError error:errors){
        errorlist.put(error.getField(),error.getDefaultMessage());
    }
    return ResponseEntity.badRequest().body(errorlist);
}
}

