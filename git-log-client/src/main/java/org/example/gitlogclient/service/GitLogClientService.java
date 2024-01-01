package org.example.gitlogclient.service;


import org.example.gitlogclient.model.GitLogResponseDTO;
import org.example.gitlogclient.model.GitRepositoryRequestDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GitLogClientService {

    Mono<String> registerRepository(GitRepositoryRequestDTO gitRepositoryRequestDTO);

    Flux<GitLogResponseDTO> getLogs(String repositoryUrl, Integer logsCount);
}
