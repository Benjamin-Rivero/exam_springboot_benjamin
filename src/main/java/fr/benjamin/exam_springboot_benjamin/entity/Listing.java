package fr.benjamin.exam_springboot_benjamin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int producedYear;

    @Column(nullable = false)
    private Long mileage;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Date createdAt;

    private String image;

    private String slug;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "model_id",nullable = false)
    private Model model;

}