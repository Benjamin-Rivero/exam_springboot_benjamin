package fr.benjamin.exam_springboot_benjamin.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.benjamin.exam_springboot_benjamin.dto.ListingDTO;
import fr.benjamin.exam_springboot_benjamin.entity.Listing;
import fr.benjamin.exam_springboot_benjamin.json_view.JsonViews;
import fr.benjamin.exam_springboot_benjamin.service.ListingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/listing")
public class ListingRestController {

    private final ListingService listingService;

    @GetMapping
    @JsonView(JsonViews.ListingListView.class)
    public List<Listing> list(){
        return this.listingService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.ListingShowView.class)
    public Listing show(@PathVariable Long id){
        return this.listingService.findById(id);
    }

    @PostMapping
    @JsonView(JsonViews.ListingShowView.class)
    public Listing create(@Valid @RequestBody ListingDTO listingDTO){
        return this.listingService.persist(listingDTO,null);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.ListingShowView.class)
    public Listing update(@Valid @RequestBody ListingDTO listingDTO,@PathVariable Long id){
        return this.listingService.persist(listingDTO,id);
    }


}