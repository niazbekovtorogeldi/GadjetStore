package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.config.JwtService;
import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.entity.Favorite;
import com.example.springprojectlms.entity.Product;
import com.example.springprojectlms.entity.User;
import com.example.springprojectlms.repository.FavoriteRepository;
import com.example.springprojectlms.repository.ProductRepository;
import com.example.springprojectlms.repository.UserRepository;
import com.example.springprojectlms.service.FavoriteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final JwtService jwtService;

    @Override
    public SimpleResponse getAllFavorite() {
        return null;
    }

    @Override
    public SimpleResponse savetheUserFavoriteProducts(Long productId) {
        User user = jwtService.getAuthentication();
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new UsernameNotFoundException(String.format("Product with  id %s doesnt exist ", productId)));
        List<Product> products = new ArrayList<>();
        List<Favorite> favorites = new ArrayList<>();
        products.add(product);
        Favorite favorite = new Favorite();
        favorite.setProduct(products);
        product.setFavorite(favorite);
        user.setFavorite(favorites);
        favorite.setUsers(user);
        favoriteRepository.save(favorite);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Product with name %s successfully added to user with name %s to  favorite table ", product.getName(), user.getFirstName()))
                .build();
    }

    @Override
    public SimpleResponse deleted(Long productId) {
        return favoriteRepository.deleteProductUser(productId);

//       User user = jwtService.getAuthentication();
//        List<Favorite> favorites = user.getFavorite();
//        for (Favorite f : favorites
//        ) {
//            List<Product> products = f.getProduct();
//            boolean removed = products.removeIf(product -> product.getId().equals(productId));
//
//            if (removed) {
//                f.setProduct(products);
//                favoriteRepository.delete(f);
//                favoriteRepository.save(f);
//
//                return SimpleResponse.builder()
//                        .status(HttpStatus.OK)
//                        .message(String.format("Product with id %s successfully removed !", productId))
//                        .build();
//
//            }
//        }
//        return SimpleResponse.builder()
//                .status(HttpStatus.NOT_FOUND)
//                .message(String.format("Product with name %s not found ",productId ))
//                .build();

    }



    @Override
    public List<ProductResponse> findAllByUsers(Long id){
        return favoriteRepository.findAllByUsers(id);
    }
}