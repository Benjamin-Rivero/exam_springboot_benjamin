package fr.benjamin.exam_springboot_benjamin.controller;

import fr.benjamin.exam_springboot_benjamin.entity.Listing;
import fr.benjamin.exam_springboot_benjamin.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(path="/listing",name="AppListing")
@AllArgsConstructor
public class ListingController {

    private final ListingService listingService;

    @GetMapping(path = "/{slug}", name = "show")
    public ModelAndView show(
            @PathVariable String slug,
            ModelAndView mav
    ) {
        Listing listing = listingService.findBySlug(slug);
        mav.setViewName("listing/listing");
        mav.addObject("listing", listing);
        return mav;
    }

}
