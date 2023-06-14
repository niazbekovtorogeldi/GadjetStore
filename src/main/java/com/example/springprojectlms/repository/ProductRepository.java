package com.example.springprojectlms.repository;
import com.example.springprojectlms.dto.dtoProduct.ProductRequest;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.enam.Category;
import com.example.springprojectlms.entity.Comment;
import com.example.springprojectlms.entity.Favorite;
import com.example.springprojectlms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select new com.example.springprojectlms.dto.dtoProduct.ProductResponse(p.id,p.name,p.price,p.images,p.characteristic,p.isFavorite,p.madeIn,p.category) from Product p " +
            "where p.category=:category and p.price<=:price order by p.price asc")
    List<ProductResponse> getAllProduct(Category category, int price);


//    @Query ("select c.comment from Product p join p.comment c where p.id=:id")
//    List<Comment> getAllProductComments(Long id);

    @Query ("select f from Product p join p.favorite f where p.id=:id")
    List<Favorite> getAllProductFavorites(Long id);


}
