package jackalexmark.newsaggregator.controllers;

import jackalexmark.newsaggregator.models.Journalist;
import jackalexmark.newsaggregator.repository.JournalistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JournalistController {

    @Autowired
    JournalistRepository journalistRepository;

    @GetMapping(value = "/journalists")
    public ResponseEntity<List<Journalist>> getAllPublishers(){
        return new ResponseEntity<>(journalistRepository.findAll(), HttpStatus.OK);
    }
}
