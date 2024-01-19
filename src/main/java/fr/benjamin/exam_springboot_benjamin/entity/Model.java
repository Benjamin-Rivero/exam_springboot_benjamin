package fr.benjamin.exam_springboot_benjamin.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.benjamin.exam_springboot_benjamin.entity.interfaces.SluggerInterface;
import fr.benjamin.exam_springboot_benjamin.json_view.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Model implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViews.ModelView.class)
    private String name;

    private String slug;

    @ManyToOne
    @JoinColumn(name="brand_id",nullable = false)
    private Brand brand;


    @Override
    public String getField() {
        return name;
    }
}