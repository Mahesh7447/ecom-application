package com.ecomm.app.converters;

import com.ecomm.app.dto.ProductDTO;
import com.ecomm.app.model.Product;
import org.springframework.stereotype.Component;

public class ProductConverter {
    public static Product dtoToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setProductName(dto.getProductName());
        product.setProductDescription(dto.getProductDescription());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        return product;
    }
    public static ProductDTO entityToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setProductDescription(product.getProductDescription());
        dto.setQuantity(product.getQuantity());
        dto.setPrice(product.getPrice());
        dto.setImage(product.getImage());
        return dto;
    }
}
