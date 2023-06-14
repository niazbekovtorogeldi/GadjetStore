package com.example.springprojectlms.service.impl;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoProduct.ProductRequest;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.enam.Category;
import com.example.springprojectlms.entity.Brand;
import com.example.springprojectlms.entity.Favorite;
import com.example.springprojectlms.entity.Product;
import com.example.springprojectlms.repository.BrandRepository;
import com.example.springprojectlms.repository.ProductRepository;
import com.example.springprojectlms.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    @Override
    public List<ProductRequest> getAllProducts(Category category, int price) {
//        return productRepository.getAllProduct(category, price);
        return null;
    }

    @Override
    public SimpleResponse saveProduct(ProductRequest productRequest, Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new UsernameNotFoundException("Brand is not found"));
        Product product = new Product();
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.setImage(productRequest.image());
        product.setCharacteristic(productRequest.characteristic());
        product.setIsFavorite(false);
        product.setMadeIn(productRequest.madeIn());
        product.setCategory(productRequest.category());
        product.setBrand(brand);
        productRepository.save(product);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Product with name: " + product.getName() + " successfully saved")
                .build();
    }

    @Override
    public SimpleResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Product with id:" + id + " is not found!"));
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.getImage().addAll(productRequest.image());
        product.setCharacteristic(productRequest.characteristic());
        product.setMadeIn(productRequest.madeIn());
        product.setCategory(productRequest.category());
        productRepository.save(product);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Product with name: " + product.getName() + " successfully updated!")
                .build();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NullPointerException("Product with id:" + id + " is not found!"));
//        List<Comment> allProductComments = productRepository.getAllProductComments(id);
        List<Favorite> favorites = productRepository.getAllProductFavorites(id);
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .image(product.getImage())
                .characteristic(product.getCharacteristic())
                .isFavorite(product.getIsFavorite())
                .madeIn(product.getMadeIn())
                .category(product.getCategory())

                .build();
    }

    @Override
    public SimpleResponse deleteProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else throw new NullPointerException("User with ID: " + id + " is not found");

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Successfully deleted")
                .build();
    }
}
