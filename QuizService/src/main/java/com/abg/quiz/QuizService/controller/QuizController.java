package com.abg.quiz.QuizService.controller;

import com.abg.quiz.QuizService.client.QuizFeign;

import com.abg.quiz.QuizService.common.annotation.ActivityLog;
import com.abg.quiz.QuizService.common.enums.AdminFeatureEnum;
import com.abg.quiz.QuizService.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import com.abg.quiz.QuizService.service.IncriptionService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

import java.time.Duration;
import java.time.Instant;


@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    @Autowired
    private IncriptionService incriptionService;
    @Value("${key.encrypt.data}")
    private String key;
    @Autowired
    private QuizFeign feign;

    @GetMapping("/get")
    public ResponseEntity<Question> getQuestion() {
        return feign.getQ();
    }


    @ActivityLog(featureId = AdminFeatureEnum.FETCH_ACTIVITY_TYPE)
    @GetMapping("/getAll")
    public ResponseEntity<List<Question>> prepareJson() {
        List<Question> list = new ArrayList<>();
        list.add(new Question(1, "How?"));
        list.add(new Question(2, "Why?"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/greeting")
    public String getGreeting() {
        return "Pocket backend service";

}
