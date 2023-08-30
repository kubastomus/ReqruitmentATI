package com.example.reqruitmentatigithubapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GitHubController {

    private final GitHubService gitHubService;

    @Autowired
    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping(value = "/repositories", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GitHubRepository>> getRepositoriesJson(
            @RequestParam String username, @RequestHeader("Accept") String acceptHeader) {
        List<GitHubRepository> repositories = gitHubService.getRepositories(username);
        return ResponseEntity.ok(repositories);
    }

    @GetMapping(value = "/repositories", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getRepositoriesXml(
            @RequestParam String username, @RequestHeader("Accept") String acceptHeader) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body("XML format not supported");
    }

}
