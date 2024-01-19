package fr.benjamin.exam_springboot_benjamin.service;

import fr.benjamin.exam_springboot_benjamin.dto.BrandDTO;
import fr.benjamin.exam_springboot_benjamin.entity.Brand;
import fr.benjamin.exam_springboot_benjamin.exception.NotFoundEntityException;
import fr.benjamin.exam_springboot_benjamin.repository.BrandRepository;
import fr.benjamin.exam_springboot_benjamin.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    private final Slugger slugger;

    public List<Brand> findAll(){
        /*List<Brand> brands = brandRepository.findAll();
        boolean hasFlush = false;
        for (Brand brand : brands) {
            if (brand.getSlug() == null) {
                brand.setSlug(slugger.slugify(brand.getName()));
                hasFlush = true;
            }
        }
        if (hasFlush) {
            brandRepository.flush();
        }
        return brands;*/

        return this.brandRepository.findAll();
    }


    public Brand findById(Long id) {
        return this.brandRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException("Brand","id",id));
    }

    public Brand persist(BrandDTO brandDTO,Long id){
        Brand brand = new Brand();
        if (id != null && brandRepository.findById(id).isEmpty()) {
            throw new NotFoundEntityException(
                    "Brand", "id", id
            );
        }
        brand.setId(id);
        brand.setName(brandDTO.getName());
        return this.brandRepository.saveAndFlush(brand);
    }
}