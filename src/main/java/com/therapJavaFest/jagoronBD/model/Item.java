package com.therapJavaFest.jagoronBD.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category;

    @Column
    private String logo;

    @Column
    private String image;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String link;


}
