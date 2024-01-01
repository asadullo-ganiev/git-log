package org.example.gitlogclient.controller;

import org.example.gitlogclient.model.GitLogResponseDTO;
import org.example.gitlogclient.model.GitRepositoryRequestDTO;
import org.example.gitlogclient.service.GitLogClientService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GitLogController {

    private final GitLogClientService gitLogClientService;

    public GitLogController(GitLogClientService gitLogClientService) {
        this.gitLogClientService = gitLogClientService;
    }

    @PostMapping("/register")
    public Mono<String> registerRepositoryByUrl(@RequestBody GitRepositoryRequestDTO gitRepositoryRequestDTO) {
        return gitLogClientService.registerRepository(gitRepositoryRequestDTO);
    }

    @GetMapping("/logs")
    public Flux<GitLogResponseDTO> getLogsByRepositoryUrl(@RequestParam String repositoryUrl,
                                                          @RequestParam Integer logsCount) {
        return gitLogClientService.getLogs(repositoryUrl, logsCount);
    }
}
