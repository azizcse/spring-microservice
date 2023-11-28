package com.abg.quiz.QuizService.controller;

import com.abg.quiz.QuizService.client.QuizFeign;
import com.abg.quiz.QuizService.utils.JsonUtil;
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
    public ResponseEntity<Question> getQuestion() {
        return feign.getQ();
    }

    @GetMapping("/json")
    public String prepareJson() {
        Question obj = new Question(1, "What?");
        String html = new String("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
        String res = JsonUtil.toJson(html);
        return "API execute success: " + res;
    }
}
