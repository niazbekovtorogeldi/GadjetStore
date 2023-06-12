package com.example.springprojectlms.dto.dtoProduct;

import com.example.springprojectlms.enam.Category;
import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder

public class ProductResponse {
    private Long id;
    private int price;
    private List<String> image;
    private String characteristic;
    private boolean isFavorite;
    private String madeIn;
    private Category category;

    public ProductResponse(Long id, int price, List<String> image, String characteristic, boolean isFavorite, String madeIn, Category category) {
        this.id = id;
        this.price = price;
        this.image = image;
        this.characteristic = characteristic;
        this.isFavorite = isFavorite;
        this.madeIn = madeIn;
        this.category = category;
    }
}
