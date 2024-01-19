package fr.benjamin.exam_springboot_benjamin.controller_api;

import fr.benjamin.exam_springboot_benjamin.dto.BrandDTO;
import fr.benjamin.exam_springboot_benjamin.entity.Brand;
import fr.benjamin.exam_springboot_benjamin.service.BrandService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brand")
public class BrandRestController {

    private final BrandService brandService;

    @GetMapping
    public List<Brand> list(){
        return this.brandService.findAll();
    }

    @GetMapping("/{id}")
    public Brand show(
            @PathVariable Long id
    ){
        return this.brandService.findById(id);
    }

    @PostMapping
    public Brand create(@Valid @RequestBody BrandDTO brandDTO){
        return this.brandService.persist(brandDTO,null);
    }

    @PutMapping("/{id}")
    public Brand update(@Valid @RequestBody BrandDTO brandDTO,@PathVariable Long id){
        return this.brandService.persist(brandDTO,id);
    }

}