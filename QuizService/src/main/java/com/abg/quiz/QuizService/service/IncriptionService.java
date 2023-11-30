package com.abg.quiz.QuizService.service;

import com.abg.quiz.QuizService.model.VerifyUser;

public interface IncriptionService {
    String encrept(String msg, String key);
    String decrypt(String msg, String key);
}
