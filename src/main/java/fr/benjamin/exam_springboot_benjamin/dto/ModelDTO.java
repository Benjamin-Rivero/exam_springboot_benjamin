package fr.benjamin.exam_springboot_benjamin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter
public class ModelDTO {

    @NotBlank(message = "The model name must have a value")
    private String name;

    @NotNull(message = "The brand id must have a value")
    private Long brandId;

}
