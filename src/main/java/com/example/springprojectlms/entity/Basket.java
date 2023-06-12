package com.example.springprojectlms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(generator = "basket_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "basket_gen", sequenceName = "basket_seq", allocationSize = 1)
    private Long id;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private List<Product>products;
    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private User user;
}
