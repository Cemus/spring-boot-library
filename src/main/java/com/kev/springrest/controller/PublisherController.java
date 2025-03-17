package com.kev.springrest.controller;

import com.kev.springrest.model.Publisher;
import com.kev.springrest.service.PublisherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("/publisher")
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        publisherService.savePublisher(publisher);
        return publisher;
    }
}
