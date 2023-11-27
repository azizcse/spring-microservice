package com.abg.quiz.QuizService.client;

import com.abg.quiz.QuizService.controller.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("QUESTION-SERVICE")
public interface QuizFeign {
    @GetMapping("/api/question")
    ResponseEntity<Question> getQ();
}
