package fr.benjamin.exam_springboot_benjamin.repository;

import fr.benjamin.exam_springboot_benjamin.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long>,EntityNameRepository<Model>,EntitySlugRepository<Model> {

}