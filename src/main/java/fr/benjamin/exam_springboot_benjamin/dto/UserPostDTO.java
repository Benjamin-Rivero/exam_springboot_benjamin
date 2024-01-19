package fr.benjamin.exam_springboot_benjamin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class UserPostDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
