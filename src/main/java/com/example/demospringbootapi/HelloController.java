package com.example.demospringbootapi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class HelloController {
@GetMapping("/hello")
public String hello(@RequestParam String name){
    return "Hello "+name +" hope you are doing well.Be strong!";
}
@GetMapping("/products")
public Product product(){
    return new Product(1,"laptop",50000);
}}

