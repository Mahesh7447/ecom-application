package com.ecomm.app.service;

import com.ecomm.app.converters.ProductConverter;
import com.ecomm.app.dto.ProductDTO;
import com.ecomm.app.exception.ProductNotFoundException;
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
    public ProductDTO findById(long id) throws ProductNotFoundException {
        Product product=productRepository.findById(id).orElse(null);
        if(product!=null){
            return ProductConverter.entityToDTO(product);
        }
        else
            throw new ProductNotFoundException("Product does not exist with id: "+id);
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
    public boolean delete(long id) throws ProductNotFoundException {
        Product product=productRepository.findById(id).orElse(null);
        if(product!=null){
            productRepository.delete(product);
            return true;
        }
        else
            throw new ProductNotFoundException("Product does not exist to delete");
    }
}
