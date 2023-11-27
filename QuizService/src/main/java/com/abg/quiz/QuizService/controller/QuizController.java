package com.abg.quiz.QuizService.controller;

import com.abg.quiz.QuizService.client.QuizFeign;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class QuizController {
    @Autowired
    private QuizFeign feign;

    @GetMapping("/qfq")
    public ResponseEntity<Question> getQuestion(){
        return feign.getQ();
    }
}
