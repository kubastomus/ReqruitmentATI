package com.example.reqruitmentatigithubapi;

public class GitHubUserNotFoundException extends RuntimeException {
    public GitHubUserNotFoundException (String message) {
        super(message);
    }
}
