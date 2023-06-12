package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoFavorite.FavoriteRequest;
import com.example.springprojectlms.entity.Favorite;
import com.example.springprojectlms.entity.User;
import com.example.springprojectlms.repository.FavoriteRepository;
import com.example.springprojectlms.service.FavoriteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRepository favoriteRepository;

    @Override
    public SimpleResponse saveFavorite(FavoriteRequest favoriteRequest) {
        Favorite favorite = new Favorite();
        return null;
    }

    @Override
    public SimpleResponse deleteFavorite(Long id) {
        return null;
    }
}
