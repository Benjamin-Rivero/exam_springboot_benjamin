package fr.benjamin.exam_springboot_benjamin.controller_api;

import fr.benjamin.exam_springboot_benjamin.dto.ModelDTO;
import fr.benjamin.exam_springboot_benjamin.entity.Model;
import fr.benjamin.exam_springboot_benjamin.service.BrandService;
import fr.benjamin.exam_springboot_benjamin.service.ModelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/model")
public class ModelRestController {

    private ModelService modelService;

    @GetMapping
    public List<Model> list(){
        return this.modelService.findAll();
    }

    @GetMapping("/{id}")
    public Model show(@PathVariable Long id){
        return this.modelService.findById(id);
    }

    @PostMapping
    public Model create(@Valid @RequestBody ModelDTO modelDTO){
        return this.modelService.persist(modelDTO,null);
    }

    @PutMapping("/{id}")
    public Model update(@Valid @RequestBody ModelDTO modelDTO,@PathVariable Long id){
        return this.modelService.persist(modelDTO,id);
    }

}