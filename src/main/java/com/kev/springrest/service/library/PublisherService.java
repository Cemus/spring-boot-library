package com.kev.springrest.service.library;

import com.kev.springrest.exception.library.PublisherBadRequestException;
import com.kev.springrest.exception.library.PublisherExistsException;
import com.kev.springrest.model.Publisher;
import com.kev.springrest.repository.PublisherRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Data
@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public void savePublisher(final Publisher publisher) {
        Iterable<Publisher> publishers= publisherRepository.findAll();

        if (publisher.getLabel() == null || publisher.getDescription().isEmpty()) {
            throw new PublisherBadRequestException(publisher.getLabel());
        }

        for (Publisher p : publishers) {
            if (Objects.equals(p.getLabel(), publisher.getLabel())){
                throw new PublisherExistsException(publisher.getLabel(), publisher.getId());
            }
        }

        publisherRepository.save(publisher);
    }
}
