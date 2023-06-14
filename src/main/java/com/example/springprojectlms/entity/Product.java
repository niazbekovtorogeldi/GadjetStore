package com.example.springprojectlms.entity;

import com.example.springprojectlms.enam.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Locale;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "product_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_gen", sequenceName = "product_seq", allocationSize = 1)
    private Long id;
    private String name;
    private int price;
    @Lob
    private List<String> image;
    private String characteristic;
    private Boolean isFavorite;
    private String madeIn;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private Brand brand;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},mappedBy = "products")
    private List<Basket>basket;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private Favorite favorite;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private Comment comment;

}
