package com.example.springprojectlms.dto.dtoProduct;

import com.example.springprojectlms.enam.Category;

import lombok.Builder;


import java.util.List;

@Builder

public record ProductRequest(
         String name,
         int price,
         List<String> image,
         String characteristic,
         boolean isFavorite,
         String madeIn,
         Category category) {




}
