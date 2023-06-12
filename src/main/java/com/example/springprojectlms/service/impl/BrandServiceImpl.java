package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoBrand.BrandRequest;
import com.example.springprojectlms.dto.dtoBrand.BrandResponse;
import com.example.springprojectlms.entity.Brand;
import com.example.springprojectlms.repository.BrandRepository;
import com.example.springprojectlms.service.BrandService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    @Override
    public List<BrandResponse> getAllBrands() {

        return brandRepository.getAllBrand();
    }

    @Override
    public SimpleResponse saveBrand(BrandRequest brandRequest) {
        Brand brand = new Brand();
        brand.setBrandName(brandRequest.brandName());
        brand.setImage(brandRequest.image());
        brandRepository.save(brand);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format(""))
                .build();
    }

    @Override
    public SimpleResponse updateBrandById(Long id, BrandRequest brandRequest) {
        Brand brand = brandRepository.findById(id).orElseThrow(()->
                new NullPointerException("not"));
        brand.setBrandName(brandRequest.brandName());
        brand.setImage(brandRequest.image());
        brandRepository.save(brand);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format(""))
                .build();
    }

    @Override
    public BrandResponse getBrandById(Long id) {
        return brandRepository.findBrandById(id).orElseThrow(()->
                new NullPointerException("not"));
    }

    @Override
    public SimpleResponse deleteBrandById(Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(()->
                new NullPointerException("not"));
         brandRepository.delete(brand);
         return SimpleResponse.builder()
                 .status(HttpStatus.OK)
                 .message(String.format(""))
                 .build();
    }
}
