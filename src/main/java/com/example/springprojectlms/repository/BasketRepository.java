package com.example.springprojectlms.repository;

import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {

    @Query("select new com.example.springprojectlms.dto.dtoProduct.ProductResponse(" +
            "p.id,p.name,p.price,p.image,p.characteristic,p.category)" +
            " from Basket b join b.products p where b.user.id=:userId")
    List<ProductResponse> getAllProductsUserId(@Param("userId") Long userId);
}
