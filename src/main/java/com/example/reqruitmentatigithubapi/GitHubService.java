package com.example.reqruitmentatigithubapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class GitHubService {

    private final RestTemplate restTemplate;

    @Value("${github.api.url}")
    private String githubApiUrl;

    @Value("${github.api.token}")
    private String githubApiToken;

    @Autowired
    public GitHubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubRepository> getRepositories(String username) {
        String apiUrl = githubApiUrl + "/users/" + username + "/repos";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + githubApiToken);

        ResponseEntity<GitHubRepository[]> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, new HttpEntity<>(headers), GitHubRepository[].class);

        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new GitHubUserNotFoundException("User not found");
        }

        List<GitHubRepository> repositories = Arrays.asList(response.getBody());
        return repositories.stream()
                .filter(repo -> !repo.isFork())
                .map(this::populateBranches)
                .collect(Collectors.toList());
    }

    private GitHubRepository populateBranches(GitHubRepository repository) {
        // Wywołaj API GitHub, aby pobrać gałęzie i ich ostatnie sha zatwierdzenia dla repozytorium
        // Wypełnij listę gałęzi w obiekcie repozytorium
        return repository;
    }

}
