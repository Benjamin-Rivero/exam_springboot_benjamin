package fr.benjamin.exam_springboot_benjamin.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.benjamin.exam_springboot_benjamin.dto.UserPostDTO;
import fr.benjamin.exam_springboot_benjamin.dto.UserPutDTO;
import fr.benjamin.exam_springboot_benjamin.entity.User;
import fr.benjamin.exam_springboot_benjamin.json_view.JsonViews;
import fr.benjamin.exam_springboot_benjamin.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {


    private final UserService userService;
    @GetMapping("/{id}")
    @JsonView(JsonViews.UserShowView.class)
    public User show(@PathVariable Long id){
        return this.userService.findById(id);
    }

    @PostMapping
    @JsonView(JsonViews.UserShowView.class)
    public User create(@Valid @RequestBody UserPostDTO userDTO){
        return this.userService.create(userDTO);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.UserShowView.class)
    public User update(@Valid @RequestBody UserPutDTO userPutDTO, @PathVariable Long id){
        return this.userService.update(userPutDTO,id);
    }


}