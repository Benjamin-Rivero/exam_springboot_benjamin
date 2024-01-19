package fr.benjamin.exam_springboot_benjamin.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor@Getter@Setter@NoArgsConstructor
public class BrandDTO {

    @NotBlank(message = "The brand name must have a value")
    private String name;

}
