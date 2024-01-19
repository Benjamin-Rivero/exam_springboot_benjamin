package fr.benjamin.exam_springboot_benjamin.controller_api;


import fr.benjamin.exam_springboot_benjamin.custom_response.JwtTokenResponse;
import fr.benjamin.exam_springboot_benjamin.dto.UserLoginDTO;
import fr.benjamin.exam_springboot_benjamin.dto.UserPostDTO;
import fr.benjamin.exam_springboot_benjamin.entity.User;
import fr.benjamin.exam_springboot_benjamin.service.UserService;
import fr.benjamin.exam_springboot_benjamin.service.security.JwtAuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SecurityRestController {

    private UserService userService;

    private JwtAuthenticationService jwtAuthenticationService;

    @PostMapping("/register")
    User create(@RequestBody UserPostDTO userDTO) {
        return userService.create(userDTO);
    }

    @PostMapping("/login")
    ResponseEntity<JwtTokenResponse> create(@RequestBody UserLoginDTO userLoginDTO) {
        return jwtAuthenticationService.authenticate(userLoginDTO);
    }

}
