package jackalexmark.newsaggregator.controllers;

import jackalexmark.newsaggregator.models.Story;
import jackalexmark.newsaggregator.models.Tag;
import jackalexmark.newsaggregator.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @CrossOrigin(origins = "http://localhost:8080/api")
    @GetMapping(value = "/tags")
    public ResponseEntity<List<Tag>> getAllTags(){
        return new ResponseEntity<>(tagRepository.findAll(), HttpStatus.OK);
    }

}
