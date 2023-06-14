package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoProduct.ProductRequest;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.enam.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    List<ProductRequest> getAllProducts(Category category, int price);

    //    List<ProductRequest> getAllProducts(Category category, int price);
    SimpleResponse saveProduct(ProductRequest productRequest,Long brandId);
    SimpleResponse updateProduct(Long id, ProductRequest productRequest);
    ProductResponse getProductById(Long id);
    SimpleResponse deleteProductById(Long id);
}
