package com.ecomm.app.service;

import com.ecomm.app.converters.ProductConverter;
import com.ecomm.app.dto.ProductDTO;
import com.ecomm.app.model.Product;
import com.ecomm.app.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductService implements IService<ProductDTO> {
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> ProductConverter.entityToDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(long id) {
        return  productRepository.findById(id).stream()
                .map(product -> ProductConverter.entityToDTO(product))
                .findFirst()
                .get();
    }
    @Override
    public boolean save(ProductDTO productDTO) {
        if (productDTO != null) {
            productRepository.save(ProductConverter.dtoToEntity(productDTO));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        productRepository.deleteById(id);
        return true;
    }
}
