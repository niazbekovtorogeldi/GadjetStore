package com.example.springprojectlms.repository;

import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select new com.example.springprojectlms.dto.dtoProduct.ProductResponse(p.id,p.isFavorite,p.price,p.characteristic,p.category,p.image,p.madeIn)from Product  p")
    List<ProductResponse> getAllProducts();

    Optional<ProductResponse> findProductById(Long id);
}
