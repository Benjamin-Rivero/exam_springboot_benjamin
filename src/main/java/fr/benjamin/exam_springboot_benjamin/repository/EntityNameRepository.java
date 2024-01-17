package fr.benjamin.exam_springboot_benjamin.repository;

import java.util.Optional;

public interface EntityNameRepository<T> {

    Optional<T> findByName(String name);

}
