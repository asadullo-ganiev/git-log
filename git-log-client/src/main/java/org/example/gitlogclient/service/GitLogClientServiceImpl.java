package org.example.gitlogclient.service;

import org.example.gitlogclient.config.ServerEndpointConfig;
import org.example.gitlogclient.model.GitLogResponseDTO;
import org.example.gitlogclient.model.GitRepositoryRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GitLogClientServiceImpl implements GitLogClientService{

    private final WebClient webClient;
    private final ServerEndpointConfig serverEndpointConfig;

    public GitLogClientServiceImpl(WebClient webClient, ServerEndpointConfig serverEndpointConfig) {
        this.webClient = webClient;
        this.serverEndpointConfig = serverEndpointConfig;
    }

    @Override
    public Mono<String> registerRepository(GitRepositoryRequestDTO gitRepositoryRequestDTO) {
        return webClient.post()
                .uri(serverEndpointConfig.getGitServerEndpoint() + "/register")
                .body(Mono.just(gitRepositoryRequestDTO), GitRepositoryRequestDTO.class)
                .retrieve()
                .bodyToMono(String.class);
    }

    @Override
    public Flux<GitLogResponseDTO> getLogs(Integer logsCount) {
        return webClient.get()
                .uri(serverEndpointConfig.getGitServerEndpoint(), uriBuilder -> uriBuilder
                        .path("/logs")
                        .queryParam("logsCount", logsCount.toString())
                        .build())
                .retrieve()
                .bodyToFlux(GitLogResponseDTO.class);
    }
}
