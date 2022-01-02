package org.shorty.urlshortner.controller;

import org.shorty.urlshortner.model.URLRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class RESTService {

    @PostMapping("/generateShortenedURL")
    public void generateShortenedURL(@RequestBody URLRequest request){

    }

    @GetMapping("/{uid}")
    public RedirectView redirectURL(RedirectAttributes attributes, @PathVariable String uid){

        return new RedirectView("https://www.baeldung.com/spring-redirect-and-forward");
    }
}
