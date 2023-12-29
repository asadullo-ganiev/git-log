package org.example.gitlogserver.controller;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.example.gitlogserver.entity.GitLog;
import org.example.gitlogserver.model.GitRepositoryRequestDTO;
import org.example.gitlogserver.service.GitRepositoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
public class GitRepoController {

    private final GitRepositoryService gitRepositoryService;

    public GitRepoController(GitRepositoryService gitRepositoryService) {
        this.gitRepositoryService = gitRepositoryService;
    }

    @PostMapping("/register")
    public Mono<String> registerRepositoryByUrl(@RequestBody GitRepositoryRequestDTO gitRepositoryRequestDTO) throws GitAPIException, IOException {
        return gitRepositoryService.setRepositoryPublic(gitRepositoryRequestDTO.getUrl());
    }

    @GetMapping("/logs")
    public Flux<GitLog> getLogsByRepositoryUrl(@RequestParam Integer logsCount) throws GitAPIException {
        return gitRepositoryService.getLogs(logsCount);
    }

    @ExceptionHandler(GitAPIException.class)
    public Mono<ResponseEntity<?>> handleGitApiException(GitAPIException e) {
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to connect to a Git repository: " + e.getMessage()));
    }
}
