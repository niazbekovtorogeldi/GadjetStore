package com.example.springprojectlms.api;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoBrand.BrandRequest;
import com.example.springprojectlms.dto.dtoBrand.BrandResponse;
import com.example.springprojectlms.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandApi {
    private final BrandService service;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<BrandResponse> getAllBrands() {
        return service.getAllBrands();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("{id}")
    public SimpleResponse update(@PathVariable Long id, @RequestBody BrandRequest brandRequest) {
        return service.updateBrandById(id, brandRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public SimpleResponse saveBrand(@RequestBody BrandRequest brandRequest) {
        return service.saveBrand(brandRequest);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public SimpleResponse deleteBrand(@PathVariable Long id) {
        return service.deleteBrandById(id);
    }

}
