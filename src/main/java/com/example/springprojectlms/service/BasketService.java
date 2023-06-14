package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoBasket.BasketRequest;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BasketService {

    SimpleResponse addProductToUserBasket(Long productId);

    SimpleResponse deleteProductFromUserBasKet(Long productId);

    List<ProductResponse> getAllInformationUserProduct();



}
