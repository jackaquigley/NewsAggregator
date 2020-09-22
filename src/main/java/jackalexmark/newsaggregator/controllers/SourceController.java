package jackalexmark.newsaggregator.controllers;
import jackalexmark.newsaggregator.models.Source;
import jackalexmark.newsaggregator.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SourceController {

    @Autowired
    SourceRepository sourceRepository;

    @CrossOrigin(origins = "http://localhost:8080/api")
    @GetMapping(value = "/sources")
    public ResponseEntity<List<Source>> getAllSources(){
        return new ResponseEntity<>(sourceRepository.findAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080/api")
    @GetMapping(value="/sources/{id}")
    public ResponseEntity<Source> getSource(@PathVariable Long id) {
        return new ResponseEntity(sourceRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping(value="/sources/{id}")
    public ResponseEntity<Source> putSource(@RequestBody Source source, @PathVariable Long id){
        Source sourceToUpdate = sourceRepository.findById(id).get();
        sourceToUpdate.setSourceTitle(source.getSourceTitle());
        sourceToUpdate.setSourceImg(source.getSourceImg());
        sourceToUpdate.setSourceLink(source.getSourceLink());
        sourceToUpdate.setPublisher(source.getPublisher());
        sourceToUpdate.setRating(source.getRating());
        sourceToUpdate.setJournalist(source.getJournalist());
        sourceToUpdate.setStory(source.getStory());
        sourceToUpdate.setComments(source.getComments());
        sourceRepository.save(sourceToUpdate);
        return new ResponseEntity<>(sourceToUpdate, HttpStatus.OK);
    }
}
