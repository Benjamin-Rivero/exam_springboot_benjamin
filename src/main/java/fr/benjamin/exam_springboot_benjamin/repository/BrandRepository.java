package fr.benjamin.exam_springboot_benjamin.repository;

import fr.benjamin.exam_springboot_benjamin.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>,EntityNameRepository<Brand> {

}