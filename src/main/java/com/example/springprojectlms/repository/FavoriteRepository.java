package com.example.springprojectlms.repository;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
//    List<Favorite> findAll(User user);
    @Query("select new com.example.springprojectlms.dto.dtoProduct.ProductResponse(p.id,p.price,p.category,p.image,p.characteristic,p.isFavorite,p.madeIn,p.category)from Product p join p.basket pb   where pb.user.id=:id")
    List<ProductResponse>findAllByUsers(Long id);
    @Modifying
@Query("delete from  Favorite f  where f.product=:productId and  f.users=:users")
    SimpleResponse deleteProductUser(@Param("productId") Long productId);
}
