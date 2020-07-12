package jackalexmark.newsaggregator.controllers;
import jackalexmark.newsaggregator.models.Source;
import jackalexmark.newsaggregator.repository.SourceRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping(value ="/sources/{id}")
    public ResponseEntity getSource(@PathVariable Long id){
        return new ResponseEntity<>(sourceRepository.findById(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080/api")
    @PatchMapping(value = "/sources/{id}")
    public ResponseEntity updateSource(@RequestBody Source source){
        sourceRepository.save(source);
        return new ResponseEntity<>(source, HttpStatus.OK);
    }


}
