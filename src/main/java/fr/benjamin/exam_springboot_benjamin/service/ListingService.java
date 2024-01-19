package fr.benjamin.exam_springboot_benjamin.service;

import fr.benjamin.exam_springboot_benjamin.dto.ListingDTO;
import fr.benjamin.exam_springboot_benjamin.entity.Listing;
import fr.benjamin.exam_springboot_benjamin.entity.Model;
import fr.benjamin.exam_springboot_benjamin.exception.NotFoundEntityException;
import fr.benjamin.exam_springboot_benjamin.repository.ListingRepository;
import fr.benjamin.exam_springboot_benjamin.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListingService {

    private final ListingRepository listingRepository;
    private final UserService userService;
    private final ModelService modelService;
    private final Slugger slugger;

    public List<Listing> findAll() {
        /*List<Listing> listings = listingRepository.findAll();
        boolean hasFlush = false;
        for (Listing listing : listings) {
            if (listing.getSlug() == null) {
                listing.setSlug(slugger.slugify(listing.getField()));
                hasFlush = true;
            }
        }
        if (hasFlush) {
            listingRepository.flush();
        }
        return listings;*/
        List<Listing> listings =  this.listingRepository.findAll();
        for(Listing listing : listings){
            listing.setPrice(listing.getPrice()/100);
        }
        return listings;
    }

    public Listing findById(Long id){
        Listing listing = this.listingRepository.findById(id)
                .orElseThrow(()-> new NotFoundEntityException("Listing","id",id));
        listing.setPrice(listing.getPrice()/100);
        return listing;
    }

    public Listing persist(ListingDTO listingDTO, Long id) {
        Listing listing = new Listing();
        if (id != null && listingRepository.findById(id).isEmpty()) {
            throw new NotFoundEntityException(
                    "Listing", "id", id
            );
        }
        listing.setId(id);
        listing.setUser(this.userService.findById(listingDTO.getUserId()));
        listing.setModel(this.modelService.findById(listingDTO.getModelId()));
        listing.setTitle(listingDTO.getTitle());
        listing.setDescription(listingDTO.getDescription());
        listing.setMileage(listingDTO.getMileage());
        listing.setProducedYear(listingDTO.getProducedYear());
        listing.setPrice(listingDTO.getPrice()*100);

        return this.listingRepository.saveAndFlush(listing);
    }

    public List<Listing> findTop12ByOrderByCreatedAtDesc(){
        List<Listing> listings = this.listingRepository.findTop12ByOrderByCreatedAtDesc();
        for(Listing listing:listings){
            listing.setPrice(listing.getPrice()/100);
        }
        return listings;
    }


    public Listing findBySlug(String slug) {
        Listing listing = this.listingRepository.findBySlug(slug)
                .orElseThrow(()-> new NotFoundEntityException("Listing","slug",slug));
        listing.setPrice(listing.getPrice()/100);
        return listing;
    }
}