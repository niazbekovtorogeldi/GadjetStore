package com.example.springprojectlms.dto.dtoBrand;

import lombok.Builder;

@Builder
public class BrandResponse {
    private Long id;
    private String brandName;
    private String image;

    public BrandResponse(Long id, String brandName, String image) {
        this.id = id;
        this.brandName = brandName;
        this.image = image;
    }
}
