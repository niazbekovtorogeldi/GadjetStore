package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoFavorite.FavoriteRequest;
import org.springframework.stereotype.Service;

public interface FavoriteService {
    SimpleResponse saveFavorite(FavoriteRequest favoriteRequest);
    SimpleResponse deleteFavorite(Long id);
}
