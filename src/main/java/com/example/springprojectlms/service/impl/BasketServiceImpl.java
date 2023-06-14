package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.config.JwtService;
import com.example.springprojectlms.dto.SimpleResponse;

import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.entity.Basket;
import com.example.springprojectlms.entity.Product;
import com.example.springprojectlms.entity.User;
import com.example.springprojectlms.repository.BasketRepository;
import com.example.springprojectlms.repository.ProductRepository;
import com.example.springprojectlms.repository.UserRepository;
import com.example.springprojectlms.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final JwtService jwtService;

    @Override
    public SimpleResponse addProductToUserBasket(Long productId) {
        User user = jwtService.getAuthentication();
        Basket basket = user.getBasket();

        if (basket == null) {
            basket = new Basket();
            basket.setUser(user);
            basket.setProducts(new ArrayList<>());
        }

        Product product = productRepository.findById(productId).orElseThrow(() ->
                new UsernameNotFoundException(String.format("Product with id %s doesn't exist!", productId)));

        List<Product> products = basket.getProducts();
        products.add(product);

        basketRepository.save(basket);
        userRepository.save(user);
        productRepository.save(product);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Product with id %s successfully added to User with id %s basket!", product.getId(), user.getId()))
                .build();
    }


    @Override
    public SimpleResponse deleteProductFromUserBasKet(Long productId) {

        User user1 = jwtService.getAuthentication();
        Basket basket = user1.getBasket();
        List<Product> products = basket.getProducts();
        boolean removed = products.removeIf(product -> product.getId().equals(productId));
        if (removed) {
            basket.setProducts(products);
            basketRepository.save(basket);

            return SimpleResponse.builder()
                    .status(HttpStatus.OK)
                    .message(String.format("Product with %s id successfully removed from user with id %s basket", productId, user1.getId()))
                    .build();
        }
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Product with id %s not found !", productId))
                .build();

    }

    @Override
    public List<ProductResponse> getAllInformationUserProduct() {
        User user = jwtService.getAuthentication();
        return basketRepository.getAllProductsUserId(user.getId());

    }



}


