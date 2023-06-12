package com.example.springprojectlms.dto.dtoBasket;

import com.example.springprojectlms.entity.Product;
import lombok.Builder;

import java.util.List;
@Builder
public record BasketRequest (List<Product>products,Long userId){
}
