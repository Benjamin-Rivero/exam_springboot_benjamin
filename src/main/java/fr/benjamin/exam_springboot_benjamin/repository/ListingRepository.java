package fr.benjamin.exam_springboot_benjamin.repository;

import fr.benjamin.exam_springboot_benjamin.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long>,EntitySlugRepository<Listing> {

    List<Listing> findTop12ByOrderByCreatedAtDesc();

}