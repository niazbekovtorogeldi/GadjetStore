package com.example.springprojectlms.api;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.service.BasketService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketApi {
    private final BasketService basketService;

    @PermitAll
    @PostMapping()
    public SimpleResponse addProductToUserBasket(@PathVariable Long productId) {
        return basketService.addProductToUserBasket(productId);
    }

    @PermitAll
    @DeleteMapping("/{productId}")
    public SimpleResponse deleteProductFromUserBasket(@PathVariable Long productId) {
        return basketService.deleteProductFromUserBasKet(productId);
    }

    @PermitAll
    @GetMapping("/All")
    public List<ProductResponse> getAllProductFromUserBasket() {
        return basketService.getAllInformationUserProduct();
    }



}
