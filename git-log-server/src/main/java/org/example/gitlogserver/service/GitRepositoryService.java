package org.example.gitlogserver.service;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.example.gitlogserver.entity.GitLog;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

public interface GitRepositoryService {

    Mono<String> setRepositoryPublic(String repositoryUrl) throws GitAPIException, IOException;

    Flux<GitLog> getLogs(String repositoryUrl, int count) throws GitAPIException;

}
