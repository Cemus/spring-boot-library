package com.kev.springrest.controller;

import com.kev.springrest.model.Publisher;
import com.kev.springrest.service.PublisherService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Valid
    @PostMapping("/publisher")
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        publisherService.savePublisher(publisher);
        return publisher;
    }
}
