package com.example.springprojectlms.dto.dtoFavorite;

import lombok.Builder;

@Builder
public record FavoriteRequest(Long userId,Long productId) {
    public FavoriteRequest {
    }
}
