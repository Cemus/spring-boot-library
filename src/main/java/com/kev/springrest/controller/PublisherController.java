package com.kev.springrest.controller;

import com.kev.springrest.model.Publisher;
import com.kev.springrest.service.PublisherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("/publisher")
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        System.out.println("test");
        publisherService.savePublisher(publisher);
        return publisher;
    }
}
