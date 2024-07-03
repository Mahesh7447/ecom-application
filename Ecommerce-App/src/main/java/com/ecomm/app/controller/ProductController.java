package com.ecomm.app.controller;

import com.ecomm.app.dto.ProductDTO;
import com.ecomm.app.exception.ProductNotFoundException;
import com.ecomm.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("{id}")
    public ProductDTO findById(@PathVariable long id) throws ProductNotFoundException {
        return productService.findById(id);
    }

    @PostMapping()
    public boolean save(@RequestBody ProductDTO product) {
        return productService.save(product);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable long id) throws ProductNotFoundException {
        return productService.delete(id);
    }
}
