package fr.benjamin.exam_springboot_benjamin.controller;

import fr.benjamin.exam_springboot_benjamin.repository.ListingRepository;
import fr.benjamin.exam_springboot_benjamin.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/", name = "AppHome")
@AllArgsConstructor
public class HomeController {

    private final ListingService listingService;

    @GetMapping(name = "index")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("listings",this.listingService.findTop12ByOrderByCreatedAtDesc());
        return mav;
    }

}
