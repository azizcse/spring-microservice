package com.abg.quiz.QuizService.controller;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;
    private String question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Question(int id, String question) {
        this.id = id;
        this.question = question;
    }
    public Question(){}
}
