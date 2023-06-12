package com.example.springprojectlms.service;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoBrand.BrandRequest;
import com.example.springprojectlms.dto.dtoBrand.BrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {
    List<BrandResponse> getAllBrands();
    SimpleResponse saveBrand(BrandRequest brandRequest);
    SimpleResponse updateBrandById(Long id, BrandRequest brandRequest);
    BrandResponse getBrandById(Long id);
    SimpleResponse deleteBrandById(Long id);
}
