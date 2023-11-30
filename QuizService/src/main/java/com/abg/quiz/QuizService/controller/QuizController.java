package com.abg.quiz.QuizService.controller;

import com.abg.quiz.QuizService.client.QuizFeign;
import com.abg.quiz.QuizService.service.IncriptionService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping("/api/v1")
public class QuizController {
    @Autowired
    private IncriptionService incriptionService;
    @Value("${key.encrypt.data}")
    private String key;
    @Autowired
    private QuizFeign feign;

    @GetMapping("/qfq")
    public ResponseEntity<Question> getQuestion() {
        return feign.getQ();
    }


    private Instant oldInstant;
    @GetMapping("/ens")
    public String encryptionTest() {
        String msg = "01923456789+999999999+uuuuuuuu+kgjkjfgkdjfkdjgfkjkgjrkgjkfmgmnfjnfjsnfm";
        String encStr = incriptionService.encrept(msg, key);
        String main = incriptionService.decrypt(encStr, key);
        System.out.println("ENC : " + encStr + " Dec :" + main);

        // Assuming you have two timestamps
        Instant timestamp1 = Instant.parse("2023-11-30T12:34:56Z");
        if (oldInstant != null) {
            timestamp1 = oldInstant;
        }

        Instant timestamp2 = Instant.now(); // Current timestamp
        System.out.println("Current time :" + timestamp2.toString());
        oldInstant = timestamp2;
        // Calculate the time difference
        Duration duration = Duration.between(timestamp1, timestamp2);

        // Get the difference in seconds
        long secondsDifference = duration.getSeconds();

        return "Time difference in seconds: " + secondsDifference;

        //return "Api success :" + System.currentTimeMillis();
    }
}
