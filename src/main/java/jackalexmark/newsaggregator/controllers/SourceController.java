package jackalexmark.newsaggregator.controllers;

import jackalexmark.newsaggregator.models.Source;
import jackalexmark.newsaggregator.models.Story;
import jackalexmark.newsaggregator.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sources")
public class SourceController {

    @Autowired
    SourceRepository sourceRepository;

    @GetMapping
    public ResponseEntity<List<Source>> getAllSources(
     @RequestParam(required = false, name ="name") String name
    ){
        if (name != null){
            return new ResponseEntity(sourceRepository.findByPublisherName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(sourceRepository.findAll(), HttpStatus.OK);
    }

}
