package com.ecomm.app.controller;

import com.ecomm.app.dto.ProductDTO;
import com.ecomm.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping("{id}")
    public ProductDTO findById(@PathVariable long id) {
        return productService.findById(id);
    }

    @PostMapping()
    public boolean save(@RequestBody ProductDTO product) {
        return productService.save(product);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable long id) {
        return productService.delete(id);
    }
}
