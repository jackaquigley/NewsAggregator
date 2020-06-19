package jackalexmark.newsaggregator.controllers;

import jackalexmark.newsaggregator.models.Source;
import jackalexmark.newsaggregator.models.Story;
import jackalexmark.newsaggregator.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SourceController {

    @Autowired
    SourceRepository sourceRepository;

    @GetMapping(value = "/sources")
    public ResponseEntity<List<Source>> getAllSources() {
        return new ResponseEntity<>(sourceRepository.findAll(), HttpStatus.OK);
    }
}
