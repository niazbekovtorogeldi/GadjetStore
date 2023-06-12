package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoProduct.ProductRequest;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    SimpleResponse saveProduct(ProductRequest productRequest);
    SimpleResponse updateProduct(Long id, ProductRequest productRequest);
    ProductResponse getProductById(Long id);
    SimpleResponse deleteProductById(Long id);
}
