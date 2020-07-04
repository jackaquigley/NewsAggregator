package jackalexmark.newsaggregator.controllers;

import jackalexmark.newsaggregator.models.Publisher;
import jackalexmark.newsaggregator.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class PublisherController {

    @Autowired
    PublisherRepository publisherRepository;

    @CrossOrigin(origins = "http://localhost:8080/api")
    @GetMapping(value = "/publishers")
    public ResponseEntity<List<Publisher>> getAllPublishers(){
        return new ResponseEntity<>(publisherRepository.findAll(), HttpStatus.OK);
    }

}
