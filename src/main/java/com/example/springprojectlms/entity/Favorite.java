package com.example.springprojectlms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "favorite")
public class Favorite {
    @Id
    @GeneratedValue(generator = "favorite_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "favorite_gen", sequenceName = "favorite_seq", allocationSize = 1)
    private Long id;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private User users;
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "favorite")
    private List<Product> product;
}
