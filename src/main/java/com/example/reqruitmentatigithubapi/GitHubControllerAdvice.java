package com.example.reqruitmentatigithubapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GitHubControllerAdvice {

    @ExceptionHandler(GitHubUserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleGitHubUserNotFoundException(GitHubUserNotFoundException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("Message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(GitHubUserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NOT_ACCEPTABLE.value());
        response.put("Message", "Requested media type not supported");

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

}
