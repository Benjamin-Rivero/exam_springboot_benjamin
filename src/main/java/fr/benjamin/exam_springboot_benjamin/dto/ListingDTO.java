package fr.benjamin.exam_springboot_benjamin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class ListingDTO {

    @NotNull(message = "The userId must have a value")
    private Long userId;

    @NotNull(message = "The modelId must have a value")
    private Long modelId;

    @NotBlank(message = "The title must have a value")
    private String title;

    @NotBlank(message = "The description must have a value")
    private String description;

    @NotNull(message = "The mileage must have a value")
    private Long mileage;

    @NotNull(message = "The producedYear must have a value")
    private int producedYear;

    @NotNull(message = "The price must have a value")
    private Double price;

}
