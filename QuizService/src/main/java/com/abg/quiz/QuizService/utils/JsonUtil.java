package com.abg.quiz.QuizService.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/28/2023
 */
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String toJson(T responseBody) {
        try {
            if (responseBody instanceof String) {
                String value = (String)responseBody;
                if (value.contains("<html") || (value.startsWith("<") && value.endsWith(">"))) {
                    KeyValueObject valueObject = new KeyValueObject(value);
                    return objectMapper.writeValueAsString(valueObject);
                } else if (value.startsWith("{") && value.endsWith("}")) {
                    return value;
                }else {
                    return value;
                }
            } else {
                return objectMapper.writeValueAsString(responseBody);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting object to JSON", e);
        }
    }

    public static <T> T fromJson(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting JSON to object", e);
        }
    }
}

class KeyValueObject{
    private String response;
    KeyValueObject(String response){
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
