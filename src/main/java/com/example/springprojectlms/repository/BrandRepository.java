package com.example.springprojectlms.repository;

import com.example.springprojectlms.dto.dtoBrand.BrandResponse;
import com.example.springprojectlms.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    @Query("select new com.example.springprojectlms.dto.dtoBrand.BrandResponse(b.id,b.brandName,b.image)from Brand b")
    List<BrandResponse> getAllBrand();

    Optional<BrandResponse> findBrandById(Long id);
}
