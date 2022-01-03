package org.shorty.urlshortner.controller;

import org.shorty.urlshortner.datastore.MapDataStore;
import org.shorty.urlshortner.generator.UIDGenerator;
import org.shorty.urlshortner.model.ShortURLEntity;
import org.shorty.urlshortner.model.URLRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class RESTService {

    @Autowired
    private UIDGenerator uidGenerator;

    @Autowired
    private MapDataStore mapDataStore;

    @PostMapping("/generateShortenedURL")
    public String generateShortenedURL(@RequestBody URLRequest request){
        ShortURLEntity entity=uidGenerator.generate();
        System.out.println(request.getOriginalURL() + " -> " + entity.getUid());
        mapDataStore.getDataStore().put(entity.getId(),request.getOriginalURL());
        return entity.getUid();
    }

    @GetMapping("/{uid}")
    public RedirectView redirectURL(RedirectAttributes attributes, @PathVariable String uid){
        long id=uidGenerator.reverse(uid);
        return new RedirectView(mapDataStore.getDataStore().get(id));
    }
}