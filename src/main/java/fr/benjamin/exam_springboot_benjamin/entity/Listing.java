package fr.benjamin.exam_springboot_benjamin.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.benjamin.exam_springboot_benjamin.entity.interfaces.SluggerInterface;
import fr.benjamin.exam_springboot_benjamin.json_view.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Listing implements SluggerInterface{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViews.ListingListView.class)
    private String title;

    @Column(nullable = false)
    @JsonView(JsonViews.ListingShowView.class)
    private String description;

    @Column(nullable = false)
    @JsonView(JsonViews.ListingListView.class)
    private int producedYear;

    @Column(nullable = false)
    @JsonView(JsonViews.ListingListView.class)
    private Long mileage;

    @Column(nullable = false)
    @JsonView(JsonViews.ListingListView.class)
    private Double price;

    @Column(nullable = false)
    @JsonView(JsonViews.ListingListView.class)
    @CreationTimestamp
    private Date createdAt;

    @JsonView(JsonViews.ListingListView.class)
    private String image;

    @JsonView(JsonViews.ListingListView.class)
    private String slug;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "model_id",nullable = false)
    @JsonView(JsonViews.ListingShowView.class)
    private Model model;

    @Override
    public String getField() {
        return (model.getBrand().getName()+"-"+model.getName()+"-"+producedYear+"-"+mileage);
    }
}