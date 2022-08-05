package com.example.marketbackend.web.rest;

import com.example.marketbackend.entity.Product;
import com.example.marketbackend.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/product")
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product newProduct = productService.save(product);
        return ResponseEntity.ok(newProduct);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/product")
    public ResponseEntity<Product> update(@RequestBody Product product){
        Product newProduct = productService.save(product);
        return ResponseEntity.ok(newProduct);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getOne(@PathVariable Long id){
        Product product = productService.findOne(id);
        return ResponseEntity.ok(product);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/product")
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<Product> products = productService.findAll(pageable);
        return ResponseEntity.ok(products);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/product/code")
    public ResponseEntity getByCode(@RequestParam String code){
        Product product = productService.findByCode(code);
        return ResponseEntity.ok(product);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/product/{id}")
    public void deleteOne(@PathVariable Long id){
        productService.delete(id);
    }
}
