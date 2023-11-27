package com.abg.question.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @GetMapping("/question")
    public ResponseEntity<Question> getQuestion(){
        return new ResponseEntity<>(new Question(1, "First question this is done"), HttpStatus.OK);
    }
}
