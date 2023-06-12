package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoBasket.BasketRequest;
import org.springframework.stereotype.Service;


public interface BasketService {
    SimpleResponse saveBasket(BasketRequest basketRequest);
    SimpleResponse deleteBasketById(Long id);
}
