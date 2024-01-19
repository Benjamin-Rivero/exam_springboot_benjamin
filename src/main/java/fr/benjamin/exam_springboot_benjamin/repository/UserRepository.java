package fr.benjamin.exam_springboot_benjamin.repository;

import fr.benjamin.exam_springboot_benjamin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}