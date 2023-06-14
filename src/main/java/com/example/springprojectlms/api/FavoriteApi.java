package com.example.springprojectlms.api;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoriteApi {
    private final FavoriteService favoriteService;
    @PostMapping("/{productId}")
    public SimpleResponse saveProductUser(Long productId){
        return favoriteService.savetheUserFavoriteProducts( productId);
    }
    @DeleteMapping("/{id}")
    public SimpleResponse deleted(@PathVariable Long id){
        return favoriteService.deleted(id);
    }
    @GetMapping("/getAllUser")
    public List<ProductResponse> getAllUser(Long id){
        return favoriteService.findAllByUsers(id);
    }

}
