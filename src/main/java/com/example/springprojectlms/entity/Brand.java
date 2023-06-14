package com.example.springprojectlms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "brands")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(generator = "brand_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "brand_gen", sequenceName = "brand_seq", allocationSize = 1)
    private Long id;
    private String brandName;
    private String image;

    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},mappedBy = "brand")
    private List<Product>products;


}
