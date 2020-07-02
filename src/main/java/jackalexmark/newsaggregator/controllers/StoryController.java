package jackalexmark.newsaggregator.controllers;

import jackalexmark.newsaggregator.models.Story;
import jackalexmark.newsaggregator.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoryController {

    @Autowired
    StoryRepository storyRepository;

    @CrossOrigin(origins = "http://localhost:8080/api")
    @GetMapping(value = "/stories")
    public ResponseEntity<List<Story>> getAllPublishers(){
        return new ResponseEntity<>(storyRepository.findAll(), HttpStatus.OK);
    }

}
