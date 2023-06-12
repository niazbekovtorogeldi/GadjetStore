package com.example.springprojectlms.dto.dtoFavorite;

import lombok.Builder;

@Builder
public record FavoriteResponse (Long id,String userName,String productName) {
    public FavoriteResponse {
    }
}
