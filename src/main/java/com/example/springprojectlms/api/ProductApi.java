package com.example.springprojectlms.api;

import com.example.springprojectlms.dto.SimpleResponse;
import com.example.springprojectlms.dto.dtoBrand.BrandRequest;
import com.example.springprojectlms.dto.dtoBrand.BrandResponse;
import com.example.springprojectlms.dto.dtoProduct.ProductRequest;
import com.example.springprojectlms.dto.dtoProduct.ProductResponse;
import com.example.springprojectlms.enam.Category;
import com.example.springprojectlms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductApi {
    private final ProductService productService;
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping
    public List<ProductRequest> getAllProducts(@RequestParam String category, @RequestParam int price) {
        Category disiredCategory = Category.valueOf(category.toUpperCase());
        return productService.getAllProducts(disiredCategory,price);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
  @PostMapping("/{brandId}")
    public SimpleResponse saveProduct(@RequestBody ProductRequest productRequest,@PathVariable Long brandId) {
        return productService.saveProduct(productRequest, brandId);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("{id}")
    public SimpleResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        return productService.updateProduct(id, productRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public SimpleResponse deleteProduct(@PathVariable Long id){
        return productService.deleteProductById(id);
    }
}

