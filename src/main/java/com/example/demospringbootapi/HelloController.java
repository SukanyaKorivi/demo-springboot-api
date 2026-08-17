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

    private final ProductService productService;
    private final ProductMapper productMapper = new ProductMapper();
    private final ProductRepository productRepository;

    public HelloController(
            ProductService productService,
            ProductRepository productRepository) {

        this.productService = productService;
        this.productRepository = productRepository;
    }


    @GetMapping("/products")
    public List<ProductResponse> getProducts() {
        return productService.getAllProducts()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }


@PostMapping("/products")
public ProductResponse createProduct(
        @Valid @RequestBody ProductRequest productRequest){
    Product product = productMapper.toProduct(productRequest);
    product = productRepository.save(product);
    ProductResponse productResponse = productMapper.toResponse(product);
    return productResponse;
}
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
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

