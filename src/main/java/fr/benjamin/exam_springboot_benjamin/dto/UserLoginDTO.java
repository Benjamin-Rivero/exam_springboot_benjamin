package fr.benjamin.exam_springboot_benjamin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class UserLoginDTO {

    private String username;

    private String password;

}
