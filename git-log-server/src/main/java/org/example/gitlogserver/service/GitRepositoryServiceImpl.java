package org.example.gitlogserver.service;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.example.gitlogserver.config.GitRepoStoragePathConfig;
import org.example.gitlogserver.entity.GitLog;
import org.example.gitlogserver.entity.GitRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GitRepositoryServiceImpl implements GitRepositoryService{

    private final GitRepository gitRepository = new GitRepository();
    private final GitRepoStoragePathConfig gitRepoStoragePathConfig;

    public GitRepositoryServiceImpl(GitRepoStoragePathConfig gitRepoStoragePathConfig) {
        this.gitRepoStoragePathConfig = gitRepoStoragePathConfig;
    }


    @Override
    public Mono<String> setRepositoryPublic(String repositoryUrl) throws GitAPIException, IOException {

        File localPath = new File(gitRepoStoragePathConfig.getRepoPath());
        if (localPath.exists()) {
            FileUtils.deleteDirectory(localPath);
        }
        
        localPath.mkdirs();

        Git git = Git.cloneRepository()
                .setURI(repositoryUrl)
                .setDirectory(localPath)
                .call();

        gitRepository.connect(repositoryUrl, git);

        return Mono.just(repositoryUrl);
    }

    @Override
    public Flux<GitLog> getLogs(int count) throws GitAPIException {

        if (!this.gitRepository.getConnected())
            return Flux.empty();

        Git git = gitRepository.getGit();

        Iterable<RevCommit> remoteLogs = git.log().call();

        return Flux.fromIterable(remoteLogs)
                .map(GitLog::toGitLog)
                .take(count);
    }
}
