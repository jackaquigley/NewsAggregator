package jackalexmark.newsaggregator.controllers;

import jackalexmark.newsaggregator.models.Comment;
import jackalexmark.newsaggregator.models.Story;
import jackalexmark.newsaggregator.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD

=======
>>>>>>> a986bb84715fe0f6e1168f002e5684902979e75f

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @CrossOrigin(origins = "http://localhost:8080/api")
    @GetMapping(value = "/comments")
    public ResponseEntity<List<Comment>> getAllComments(){
        return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080/api")
    @PostMapping("/comments")
    public ResponseEntity<Comment> postComment(@RequestBody Comment comment){
        commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }


}