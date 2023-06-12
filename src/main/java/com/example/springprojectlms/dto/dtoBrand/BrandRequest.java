package com.example.springprojectlms.dto.dtoBrand;

import lombok.Builder;

@Builder
public record BrandRequest(String brandName,String image) {
    public BrandRequest {
    }
}
