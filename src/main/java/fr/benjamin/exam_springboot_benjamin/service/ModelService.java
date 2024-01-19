package fr.benjamin.exam_springboot_benjamin.service;

import fr.benjamin.exam_springboot_benjamin.dto.BrandDTO;
import fr.benjamin.exam_springboot_benjamin.dto.ModelDTO;
import fr.benjamin.exam_springboot_benjamin.entity.Brand;
import fr.benjamin.exam_springboot_benjamin.entity.Model;
import fr.benjamin.exam_springboot_benjamin.exception.NotFoundEntityException;
import fr.benjamin.exam_springboot_benjamin.repository.ModelRepository;
import fr.benjamin.exam_springboot_benjamin.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelService {


    private final ModelRepository modelRepository;
    private final BrandService brandService;
    private final Slugger slugger;

    public List<Model> findAll() {
        /*List<Model> models = modelRepository.findAll();
        boolean hasFlush = false;
        for (Model model : models) {
            if (model.getSlug() == null) {
                model.setSlug(slugger.slugify(model.getName()));
                hasFlush = true;
            }
        }
        if (hasFlush) {
            modelRepository.flush();
        }
        return models;*/
        return this.modelRepository.findAll();
    }

    public Model findById(Long id) {
        return this.modelRepository.findById(id)
                .orElseThrow(()-> new NotFoundEntityException("Model","id",id));
    }

    public Model persist(ModelDTO modelDTO, Long id){
        Model model = new Model();
        if (id != null && modelRepository.findById(id).isEmpty()) {
            throw new NotFoundEntityException(
                    "Brand", "id", id
            );
        }
        model.setId(id);
        model.setName(modelDTO.getName());
        model.setBrand(brandService.findById(modelDTO.getBrandId()));
        return this.modelRepository.saveAndFlush(model);
    }
}