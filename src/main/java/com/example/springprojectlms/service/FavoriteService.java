package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;

import java.util.List;

public interface FavoriteService {
    SimpleResponse getAllFavorite();
    SimpleResponse savetheUserFavoriteProducts(Long productId);


//    SimpleResponse deleteFavoriteisUser(Long productId);

    SimpleResponse deleted(Long productId);

    List<ProductResponse> findAllByUsers(Long id);
}
