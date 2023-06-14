package com.example.springprojectlms.dto.dtoBasket;

import com.example.springprojectlms.entity.Product;
import lombok.Builder;

import java.util.List;

@Builder
public record GetAllUsersBasketResponse(Long id, List<Product> products, int sumOfPrice, int sizeOfProducts) {
    public GetAllUsersBasketResponse {
    }
}
