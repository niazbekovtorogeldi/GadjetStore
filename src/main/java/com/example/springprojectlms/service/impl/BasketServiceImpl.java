package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoBasket.BasketRequest;
import com.example.springprojectlms.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    @Override
    public SimpleResponse saveBasket(BasketRequest basketRequest) {
        return null;
    }

    @Override
    public SimpleResponse deleteBasketById(Long id) {
        return null;
    }
}
