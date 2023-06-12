package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoProduct.ProductRequest;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.entity.Product;
import com.example.springprojectlms.repository.ProductRepository;
import com.example.springprojectlms.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public SimpleResponse saveProduct(ProductRequest productRequest) {
        Product productc= new Product();
        productc.setPrice(productRequest.price());
        productc.setCategory(productRequest.category());
        productc.setImage(productRequest.image());
        productc.setIsFavorite(productRequest.isFavorite());
        productc.setMadeIn(productRequest.madeIn());
        productRepository.save(productc);


        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format(""))
                .build();
    }

    @Override
    public SimpleResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(()->
                new NullPointerException(""));
        product.setPrice(productRequest.price());
        product.setCategory(productRequest.category());
        product.setImage(productRequest.image());
        product.setIsFavorite(productRequest.isFavorite());
        product.setMadeIn(productRequest.madeIn());
        productRepository.save(product);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format(""))
                .build();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productRepository.findProductById(id).orElseThrow(()->new NullPointerException(""));
    }

    @Override
    public SimpleResponse deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new NullPointerException(""));
        productRepository.delete(product);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format(""))
                .build();
    }
}
